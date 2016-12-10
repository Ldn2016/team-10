import requests
import csv
from io import StringIO
import plotly.plotly as py
import plotly.graph_objs as go
from time import sleep

while True:
    try:
        dataAsStrings = list(csv.reader(StringIO (requests.get('http://ec2-52-212-183-253.eu-west-1.compute.amazonaws.com:8080/getFile').text)))[0]
        underOrOver6 = []
        underOrOver6.append(dataAsStrings[0])
        dataAsInts = []

        for i in range(1, len(dataAsStrings)):
            dataAsInts.append(int(dataAsStrings[i]))

        py.sign_in('dth209','DrHbmHSJl9VfwIDra7d1')
        trace = [go.Bar(
            x=['Total Beginning of Period',
                'WFH/BMI',
                'MUAC',
                'Oedema',
                'Relapse',
                'Re-admission',
                'Total Admissions',
                'Moved in from OTP',
                'Other',
                'Total in',
                'Promoted to OTP',
                'Recovered',
                'Death',
                'Defaulter Uncofirmed',
                'Defaulter Confirmed',
                'Non-recovery Medical Referral'
                'Non-recovery Non-response',
                'Total Discharges',
                'Other'
                'Total Out',
                'Total End of Period'],
            y=dataAsInts)]

        py.iplot(trace, filename='weekly-report')  
        print("HERE2")
        requests.get('http://ec2-52-212-183-253.eu-west-1.compute.amazonaws.com:8080/deleteFile')
        print("Processed file succesfully")    
 
    except Exception as e:
        print(e)
        sleep(2)