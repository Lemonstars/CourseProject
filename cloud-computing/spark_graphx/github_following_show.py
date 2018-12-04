from pyecharts.custom.page import Page
from pyecharts import Graph
from pyecharts import Style
import pymongo
import math


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
    col_relationship = db['relationship']
    col_user = db['user']

    node = list()
    for user in col_user.find().limit(10):
        in_degree = user['in_degree']
        this_color = color_choose(in_degree)
        size = int(math.sqrt(in_degree) * 5)
        node.append({'name': user['username'], 'symbolSize': size, 'itemStyle': {'color': this_color}})

    link = list()
    for relationship in col_relationship.find():
        source = relationship['username']
        all_following = relationship['following']
        every_following = all_following.split(' ')
        num_following = len(every_following) - 1
        for i in range(num_following):
            link.append({'source': source, 'target': every_following[i]})

    style = Style(
        title_color="#fff",
        title_pos="center",
        width=2760,
        height=1440,
        background_color='#404a59'

    )

    print(node)
    print(link)

    page = Page()
    chart = Graph("Github following关系图", **style.init_style)
    chart.add("", node, link)
    page.add(chart)
    page.render()
