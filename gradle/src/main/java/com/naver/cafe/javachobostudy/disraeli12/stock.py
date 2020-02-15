import urllib.request
import json

url = "https://www.tipranks.com/api/stocks/getChartPageData/?ticker=PM&benchmark=1&period=3&break=1581737752401"
request = urllib.request.urlopen(url)
data = request.read()
encoding = request.info().get_content_charset('utf-8')
json_data = json.loads(data.decode(encoding))

print(json_data["earnings"][0]["date"])         # date
print(json_data["earnings"][0]["isConfirmed"])  # isConfirmed
