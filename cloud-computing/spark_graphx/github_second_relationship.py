from pyecharts.custom.page import Page
from pyecharts import Graph
from pyecharts import Style
import pymongo
import math


def in_degree2size(this_in_degree):
    return int(math.sqrt(this_in_degree) * 5)


def color_choose(number):
    if number > 100:
        color = 'rgba(255,102,102,0.8)'
    elif number > 70:
        color = 'rgba(255,204,0,0.8)'
    elif number > 30:
        color = 'rgba(102,153,51,0.8)'
    elif number > 15:
        color = 'rgba(51,153,204,0.8)'
    elif number > 6:
        color = 'rgba(153,50,204,0.8)'
    elif number > 2:
        color = 'rgba(205,133,63,0.8)'
    else:
        color = 'rgba(204,204,204,0.8)'
    return color


if __name__ == "__main__":
    # config the mongodb connection
    client = pymongo.MongoClient('mongodb://localhost:27017')
    db = client['github_following']
    col_user = db['user']

    # find the target user's document
    target_user_name = 'Knio'
    doc_target_user = col_user.find_one({'username': target_user_name})
    target_user_snd_relationship = doc_target_user['sndRal']
    target_user_in_degree = doc_target_user['in_degree']
    all_snd_relationship = target_user_snd_relationship.split(',')

    node = list()
    link = list()

    # add the target user node
    target_user_color = color_choose(target_user_in_degree)
    target_user_size = in_degree2size(target_user_in_degree)
    node.append({'name': target_user_name, 'symbolSize': int(target_user_size),
                 'itemStyle': {'color': target_user_color}})

    # add the secondary relationship node
    for item in all_snd_relationship:
        doc_this_user = col_user.find_one({'number': int(item)})

        this_user_name = str(doc_this_user['username'])
        if this_user_name == target_user_name:
            continue

        this_user_in_degree = doc_this_user['in_degree']
        this_user_size = in_degree2size(this_user_in_degree)
        this_user_color = color_choose(this_user_in_degree)
        node.append({'name': this_user_name, 'symbolSize': int(this_user_size),
                     'itemStyle': {'color': this_user_color}})
        # add the link
        link.append({'source': target_user_name, 'target': this_user_name})

    style = Style(
        title_color="#fff",
        title_pos="center",
        width=2760,
        height=1440,
        background_color='#404a59'
    )

    page = Page()
    chart = Graph("Github following二度关系推荐图", **style.init_style)
    chart.add("", node, link)
    page.add(chart)
    page.render()
