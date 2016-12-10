import random
import string
import os
import cherrypy
import csv
import urllib, urllib2
import requests

class StringGenerator(object):

	@cherrypy.expose
	def index(self):
		return """<html>
		<head></head>
		<body>
			<form method="get" action="writeFile">
				<input type="text" value="" name="csv" />
				<button type="submit">Input attributes</button>
			</form>
			</body>
		</html>"""

	@cherrypy.expose
	def writeFile(self, csv):
		with open('Values.csv', 'a') as file:
			file.write(csv + "\n")
		return ''

	@cherrypy.expose	
	def getFile(self):
		with open('Values.csv', 'r') as file:
			return file.readlines()

	@cherrypy.expose
	def deleteFile(self):
		os.remove("Values.csv")
		return 'File Removed'

	@cherrypy.expose
	def getInfo():
		CSV_URL = 'http://ec2-52-212-183-253.eu-west-1.compute.amazonaws.com:8080/getFile'
		
		with requests.Session() as s:
			download = s.get(CSV_URL)
		
			decoded_content = download.content.decode('utf-8')
		
			cr = csv.reader(decoded_content.splitlines(), delimiter = ',')
			my_list = list(cr)
			for row in my_list:
				print(row)
		
if __name__ == '__main__':
	cherrypy.config.update( {"server.socket_host": "0.0.0.0"} )
	cherrypy.quickstart(StringGenerator())
