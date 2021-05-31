# SILab2_165046
![CFG_function](https://user-images.githubusercontent.com/58486697/120121021-875f5780-c1a1-11eb-9407-9f64de7de42b.png)


1. Цикломатската комплексност  
#Nodes = 22  
#Edges = 29  
#Regions = 9  
  
CC= E-N+2 = 29-22+2 = 9  
CC = P+1 = 8+1 = 9  
CC = R = 9  
  
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
Branches: 3.2-4,5-6,6-7  
timeList={ (hr=-1,min=anything,sec=anything))} 
  
Branches: 3.2-4,5-6,6-8  
timeList={ (hr=25,min=anything,sec=anything)}
  
Branches: 3.2-4,5-9,9-10,10-11	  
timeList={ (hr=20,min=62,sec=anything)}	
  
Branches: 3.2-4,5-9,9-10,10-12,12-14   
timeList={ (hr=20,min=40,sec=-20)}  
  
Branches: 3.2-4,3.2-20,5-9,9-10,10-12,12-13,15-16,17-20
timeList={ (hr=20,min=40,sec=10),(hr=24,min=0,sec=0)}  
  
Branches: 3.2-4,5-9,9-15,15-17,17-18  	  
timeList={ (hr=24,min>0,sec>0)}  
  
