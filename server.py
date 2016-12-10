import random
import string
import os
import cherrypy
import csv
import urllib2
#import plotly.plotly as py
#import plotly.graph_objs as go

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
	def getInfo(self):
		with open('Values.csv', 'r') as file:
			for line in file:
				array.append(line)
		return array

class GraphGenerator(StringGenerator):
	
	def makeBarChart(self, string_generator):
		string_generator.getInfo(self)
		infoArray = string_generator.array
		print(infoArray)
	
		

if __name__ == '__main__':
	print(765764746)
	cherrypy.config.update( {"server.socket_host": "0.0.0.0"} )
	print(765764746)
	cherrypy.quickstart(GraphGenerator())
	
