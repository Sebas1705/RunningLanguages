
####Simple:####
def say_hello():
    print("Hello")
    
####Returned:####
def sum(x,y):
    return x+y

####Inferences:####
def sub(x:int,y:int) -> int|float:
    return x-y
    
####Default values:####
def pow(x:float,y:float=1.0):
    return x**y

###Superior order:####
from typing import Callable
def doOperation(x:int,y:int,op:Callable[[int,int],int]):
    return op(x,y)

####Recursive function:####
def factorial(n:(int)):
    return n if n<=1 else factorial(n-1)*n

####Args arguments:####
def sums(*args)->int:
    t=0
    for i in list(args):
        t+=i
    return t 

####Kwargs arguments:####
def printKeyValue(**kwargs):
    for k,v in kwargs.items():
        print(f"Key: {k}, Value: {v}")
    
####Lambda:####
pow:Callable[[int,int],int]=lambda x,y:x**y

####Decorators:####
def myDecorator(func):
    def wrapper(*args, **kwargs):
        print(f"Call to {func.__name__}") #code before
        result = func(*args, **kwargs) #code function
        print(f"Finish {func.__name__}") #code after
        return result
    return wrapper

@myDecorator
def func_to_decorator():
    print("Function to decorator")

if __name__ == "__main__":
    say_hello()
    print(sum(1,2))
    print(sub(3,2))
    print(doOperation(3,2,sum))
    print(factorial(3))
    print(sums(1,12,1,2,23,3,2))
    printKeyValue(x="Hola",y="Hi")
    print(pow(2,3))
    func_to_decorator()