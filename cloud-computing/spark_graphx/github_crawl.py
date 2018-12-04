import urllib.request
import urllib.error
import pymongo
import json
import queue


# get the following nicknames of a github user
def get_github_following(nickname):
    following_nick_name = list()

    try:
        url = 'https://api.github.com/users/' + nickname + '/following'
        header = {
            'Authorization': 'token a5d723fe533695853bfeab65ea66371d29ad0a15'
        }
        req = urllib.request.Request(url, headers=header)
        data = urllib.request.urlopen(req).read()
        json_data = json.loads(data)
        for item_data in json_data:
            nickname = item_data['login']
            following_nick_name.append(nickname)
    except urllib.error.HTTPError as e:
        print(e.msg)

    return following_nick_name


if __name__ == "__main__":
    # start point
    root_user = 'JakeWharton'

    # config the mongodb connection
    client = pymongo.MongoClient('mongodb://localhost:27017')
    db = client['github_following']
    col_relationship = db['relationship']
    col_user = db['user']

    # current number and max number
    user_number = 0
    relation_number = 0

    max_call_github_number = 4700
    current_call_github_number = 0

    # store the crawled user
    have_crawl_set = set()

    # store the numbered user
    have_number_set = set()

    # store the crawling user
    to_crawl_list = queue.Queue()

    to_crawl_list.put(root_user)
    col_user.insert_one({'number': user_number, 'username': root_user})
    user_number += 1
    have_number_set.add(root_user)
    while current_call_github_number <= max_call_github_number:
        if to_crawl_list.empty():
            print('Warning: the size of to_crawl_list is 0')
            break

        current_user = to_crawl_list.get()
        if not (current_user in have_crawl_set):
            # get the following data of the current user and update the queue
            user_following = get_github_following(current_user)
            current_call_github_number += 1

            user_following_combined = ''
            for item in user_following:
                user_following_combined += (item+' ')
                to_crawl_list.put(item)

                if not (item in have_number_set):
                    col_user.insert_one({'number': user_number, 'username': item})
                    have_number_set.add(item)
                    user_number += 1

            # insert data into mongodb update the number of relationship
            doc_relationship = dict()
            doc_relationship['username'] = current_user
            doc_relationship['following'] = user_following_combined
            col_relationship.insert_one(doc_relationship)
            relation_number += len(user_following)

            # update the dict in order to prevent to crawl the same user
            have_crawl_set.add(current_user)

        print('the number of users is ' + str(user_number))
        print('the number of relationship is ' + str(relation_number))



