import random
import string
import os
import cherrypy
import csv
import urllib2
#import plotly.plotly as py
#import plotly.graph_objs as go
array = []

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
	def getInfo(self):
		with open('Values.csv', 'r') as file:
			for line in file:
				array.append(line)
		return array

#class GraphGenerator()
	
#	def make

if __name__ == '__main__':
	cherrypy.config.update( {"server.socket_host": "0.0.0.0"} )
	cherrypy.quickstart(StringGenerator())
	infoArray = getInfo(self)
	print(infoArray)
	
	
	
	
	
	
	
	
	
	