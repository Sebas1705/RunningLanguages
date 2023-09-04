
####str:####
text1 = "Hello"
text2 = 'World!'
textComb = text1 + f", {text1}\n" + text2
print(str(type(textComb))+": "+textComb)

####int:####
age = 17
print(str(type(age))+": "+str(age))

####float:####
height = 1.83
print(str(type(height))+": "+str(height))

####bool:####
human = False
print(str(type(human))+": "+str(human))

####multi-assignment:####
hola, todo, tu = 1, True, "Pedro"
print(str(hola) + str(todo) + tu)

####list (ordered, same types, changeable):####
food = ["pizza", "tacos", "hamburger", "cake"]
#food.append("hotdog")#Put at last
#food.remove("hotdog")#Remove item
#food.pop()           #Remove last
#food.insert(0, "tea")#insert item in a position
#food.sort()          #sort 
#food.clear()         #remove all


####Tuple (ordered, unchangeable):####
student = ("Bro", 21, "male", 21)

print(student.count(21))    #number of times that an element in in the tuple
print(student.index(21))    #Index of an element

####Range (ordered,unchangeable):####
range1 = range(1,10)
print(range1)
rangeStep = range(1,10,2)
print(rangeStep)

#Set (unordered, unindexed, changeable, no repeatable):
utensils = {"fork", "spoon", "knife", "knife"}
dishes = {"bowl", "plate", "cup", "knife"}

#utensils.add("napkin")                     
#utensils.remove("fork")                    
#utensils.clear()                           
#utensils.update(dishes)                    # add a set
#dinner_table = utensils.union(dishes)      # union
dinner_table = utensils.intersection(dishes)# intersection
#print(utensils.difference(dishes))         # difference

print(dinner_table)

####Dictionaries (per key-value uniques, changeable, unordered):####
capitals = {"USA":"Washington DC",
            "India":"New Delhi",
            "China":"Beijing",
            "Russia":"Moscow",
            "Germany":"Berlin"}

#capitals.update({"Spain":"Madrid"})
#capitals.update({"USA": "Las Vegas"})
#capitals.pop("China")
#capitals.clear()
#print(capitals["Germany"])
#print(capitals.get("Germany"))
#print(capitals.keys())
#print(capitals.values())
#print(capitals.items())
print(capitals)

####Operands:####

#Arithmetics:
a,b=12,22
print(a+b)  #Sum
print(a-b)  #Subtract
print(a*b)  #Multiply
print(a/b)  #Division
print(a%b)  #Mod
print(a//b) #Integer division
print(a**b) #potential
print("Hola"*4) #multiple string
print(a & b) # and bit
print(a | b) # or bit 
print(a ^ b) # xor bit
print(a << b) # lshift bit
print(a >> b) # rshift bit

#Logics:
c,d,e,l=True,False,True,(1,2,3)
print(c==d);#Equal
print(c!=d);#Not equal
print(a>b);#Greater
print(a>=b);#Greater or equal
print(a<b);#Minor
print(a<=b);#Minor or equal
print(c and d);#AND
print(d or e);#OR
print(not d);#NOT
print(1 in l)#in
print(1 not in l)#not in



####Type casting:####
a:str
a = str(9.392)
print(a)
b:float = float(a)+1.21
print(str(b))

####Slicing (for all indexing structures: list,tuple,range,set,dictionary,implemented):####
list = [1,2,12,3,2,2,3,2,3]
print(list[1]) #index
print(list[4:7]) #sublist
print(list[0:9:2]) #sublist with step
print(list[-1]) #last element

###Formatting strings:####
text="""
Hello
World !!!!!
"""
animal = "cow"
item = "moon"

print("The {} jumped over the {}, {}".format(animal,item,":)"))
print("The {1} jumped over the {0}, {2}".format(animal,item,":)")) #Positional order
print("The {b} jumped over the {c}, {a}".format(a=animal,b=item,c=":)")) #keywords
print(f"The {animal} jumped over the {item}") #keywords

text = "The {} jumped over the {}, until you are {}"
print(text.format(animal,item,"happy"))

print("----------------------------------")

name="Sebas"

print("Hi {:10} nice to meet you".format(name)) #padding
print("Hi {name:<10} nice to meet you".format(name=name)) #left align
print("Hi {0:>10} nice to meet you".format(name)) #right align
print("Hi {:^10} nice to meet you".format(name)) #center align


pi=3.14159
number=1000

print("PI: {:.2f}".format(pi)) #decimal format
print(f"PI: {pi:.2f}")
print(f"Number: {number:,}") #number add comma 
print(f"Number: {number:b}") #number to binary
print(f"Number: {number:o}") #number to octal
print(f"Number: {number:x}") #number to hexadecimal lowercase
print(f"Number: {number:X}") #number to hexadecimal uppercase
print(f"Number: {number:.3e}") #number to scientific lowercase
print(f"Number: {number:.2E}") #number to scientific uppercase

###List compression (for tuples,list,set):####
list = [ x for x in range(10) if x%2!=0]
print(list)
list = [ [x,y] for x in range(3) for y in range(3) if x!=y ]
print(list)
set = { x for x in range(3) }
print(set)

####Dictionary compression:####
dict = { x:x**x for x in range(10) }
print(dict)

####Zip:####
list= tuple(zip([1,2,3,4],["Hola","Hello","Hi","World"]))
print(list)
l1,l2 = zip(*list) # unzip
print(l1)
print(l2)

####Walrus:####
vls = [1, 2, 3, 4]
squares = {valor: (square := valor ** 2) for valor in vls}
print(squares)

####__properties__:####
print(vls.__repr__()) #list representation
print(age.__class__.__name__) #class int representation
print(age.__class__) #class representation