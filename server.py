import random
import string
import os
import cherrypy
import csv
import urllib, urllib2
import urllib.request

class StringGenerator(object):

	array = []

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
			print(csv)

	@cherrypy.expose	
	def getFile(self):
		with open('Values.csv', 'r') as file:
			return file.readlines()

	@cherrypy.expose
	def deleteFile(self):
		os.remove("Values.csv")
		return 'File Removed'

	@cherrypy.expose
	def getInfo(self):
		with open('Values.csv', 'r') as file:
			for line in file:
				array.append(line)
		return array
		
	def requestInfo(self):
		with urllib.request.urlopen('http://ec2-52-212-183-253.eu-west-1.compute.amazonaws.com:8080/getFile') as response:
			html = response.read()
		return html

#class GraphGenerator(StringGenerator):
#
#	def __init__(self):
#		infoArray = StringGenerator.array
#		
#	def makeBarChart(self, infoArray):
#		string_generator.getInfo
#		print(infoArray)
		
		
if __name__ == '__main__':
	cherrypy.config.update( {"server.socket_host": "0.0.0.0"} )
	cherrypy.quickstart(StringGenerator())
	print(html + 'THISISATESTIWANTTHISTOPRINT!')
	
