

####If:####
a = 0

if a == 0:
    print("Zero")
elif a < 0:
    print("Less than zero")
else:
    print("Greater than zero")
    
####While:####

n=1
while n <= 10:
    print(n)
    n+=1
    if n == 5:
        continue
    if n == 9:
        break

####For:####
sequence=[1,2,3,4]
for i in sequence:
    print(i)
    
for i in [1,2,23,2]:
    print(i)
    
for i in range(0,10,2):
    print(i)