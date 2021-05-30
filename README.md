# SILab2_165046

1. Цикломатската комплексност
#Nodes = 21
#Edges = 27
#Regions = 8

CC= E-N+2 = 27-21+2 = 8
CC = P+1 = 7+1 = 8
CC = R = 8

2.Multiple condition критериумот
2.1 hr < 0 || hr > 24
Possible conditions:
T || X -> hr < 0
F || T -> hr > 24
F || F -> 0=>hr<=24

2.2 min < 0 || min > 59
Possible conditions:
T || X -> min < 0
F || T -> min > 59
F || F -> 0=>min<=59

2.3 sec >= 0 && sec <= 59
Possible conditions:
F && X -> sec < 0
T && F -> 0<=sec>59
T && T -> 0<=sec<=59

2.4 hr == 24 && min == 0 && sec == 0
Possible conditions:
F && X && X -> hr!=24,min=anything,sec=anything
T && F && X -> hr=24,min!=0, sec= anything
T && T && F -> hr=24,min=0,sec!=0
T && T && T -> hr=24,min=0,sec=0

3.Every branch критериум
timeList={ (hr=-1,min=anything,sec=anything))}	
timeList={ (hr=25,min=anything,sec=anything)}	
timeList={ (hr=20,min=62,sec=anything)}	
timeList={ (hr=20,min=40,sec=-20)}	
timeList={ (hr=20,min=40,sec=10),(hr=24,min=0,sec=0)}	
timeList={ (hr=24,min>0,sec>0)}
