import random
import string

import cherrypy


class StringGenerator(object):
	@cherrypy.expose
	def index(self):
		return """<html>
		<head></head>
		<body>
			<form method="get" action="writeFile">
				<input type="text" value="" name="csv" />
				<button type="submit">Enter number</button>
			</form>
			</body>
		</html>"""

	@cherrypy.expose
	def writeFile(self, csv):
		with open('test.csv', 'a') as file:
			file.write(csv + "\n")
		return ''
		
	@cherrypy.expose	
	def getFile(self):
		with open('test.csv', 'r') as file:
			return file.readlines()

if __name__ == '__main__':
	cherrypy.quickstart(StringGenerator())