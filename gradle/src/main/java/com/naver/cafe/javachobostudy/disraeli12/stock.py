import urllib.request
import bs4

url = "https://www.tipranks.com/api/stocks/getChartPageData/?ticker=PM&benchmark=1&period=3&break=1581737752401"
html = urllib.request.urlopen(url)

bsobj = bs4.BeautifulSoup(html, "html.parser")

print(bsobj)
