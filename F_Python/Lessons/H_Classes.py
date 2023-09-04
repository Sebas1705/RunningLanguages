
####Normal Class:####
class Car:
    
    #static variables(__ for private):
    __wheels=4
    
    def __init__(self,color,make,velocity,startState):
        self.__color=color
        self.__make=make
        self.__velocity=velocity
        self.__state=startState
    
    #property(decorator):
    @property
    def color(self):
        return self.__color
    @color.setter
    def color(self,color):
        self.__color=color
        
    #property(function):
    def __get__make(self):
        return self.__make
    def __set__make(self,make):
        self.__make=make
    make = property(__get__make,__set__make)
    
        
    @staticmethod
    def get_wheels():
        return Car.__wheels
    
    @staticmethod
    def isEven(x:int):
        return x%2==0
    
    #constructor for class
    @classmethod
    def default_car(cls): #cls used for reference to class, preferred for inheritance
        return cls("black","ferrari",200,"Stopped")
    
    def __str__(self):
        return f"{self.__make}: {self.color} | {self.__}"
     
    #methods:
    def drive(self):
        if self.__state=="Driving":
            print("Can't drive if it is driving")
        else:
            self.__state="Driving"
            print("This "+self.__make+" is driving")
    def stop(self):
        if self.__state=="Stopped":
            print("Can't stop if it is stopped")
        else:
            self.__state="Stopped"
            print("This "+self.__make+" is stopping")
    def say_hi(self):
        print("Hello, "+self)
        
            
####Inheritance:####
class Ferrari(Car):
    def __init__(self,velocity,startState):
        super().__init__("Red","Ferrari",velocity,startState)
    def say_hi(self):
        print("Hello sir, "+self)
        
####Polymorphisms:####
x : Car = Ferrari(200,"Stopped")
x.drive()
print(isinstance(x,Car))
print(issubclass(Ferrari,Car))

####Magic methods:####
#--Operator	Method--#
# +	        object.__add__(self, other)
# -	        object.__sub__(self, other)
# *	        object.__mul__(self, other)
# "//"	    object.__floordiv__(self, other)
# /	        object.__truediv__(self, other)
# %	        object.__mod__(self, other)
# **	    object.__pow__(self, other[, modulo])
# <<	    object.__lshift__(self, other)
# >>	    object.__rshift__(self, other)
# &	        object.__and__(self, other)
# ^	        object.__xor__(self, other)
# |	        object.__or__(self, other)
#--Extended Assignments--#
#--Operator	Method--#
# +=	    object.__iadd__(self, other)
# -=	    object.__isub__(self, other)
# *=	    object.__imul__(self, other)
# /=	    object.__idiv__(self, other)
#"//="	    object.__ifloordiv__(self, other)
# %=	    object.__imod__(self, other)
# **=	    object.__ipow__(self, other[, modulo])
# <<=	    object.__ilshift__(self, other)
# >>=	    object.__irshift__(self, other)
# &=	    object.__iand__(self, other)
# ^=	    object.__ixor__(self, other)
# |=	    object.__ior__(self, other)
# this can be radd for example to invert order (self = other + self)
#--Unary Operators--#
#--Operator	Method--#
# -	        object.__neg__(self)
# +	        object.__pos__(self)
# abs()	    object.__abs__(self)
# ~	        object.__invert__(self)
# complex()	object.__complex__(self)
# int()	    object.__int__(self)
# long()	object.__long__(self)
# float()	object.__float__(self)
# oct()	    object.__oct__(self)
# hex()	    object.__hex__(self
#--Comparison Operators--#
#--Operator	Method--#
# <	        object.__lt__(self, other)
# <=	    object.__le__(self, other)
# ==	    object.__eq__(self, other)
#"!="	    object.__ne__(self, other)
# >=	    object.__ge__(self, other)
#  >	    object.__gt__(self, other)       

class Matrix :
    
    #constructor:
    def __init__ (self , m, n, value= 0):
        self .m = m
        self .n = n
        self ._rows = [[value] * n for _ in range (m)]
    
    #get for [idx]
    def __getitem__ (self , idx):
        return self ._rows[idx]
    
    #set for [idx]
    def __setitem__ (self , idx, item):
        self ._rows[idx] = item
    
    #representation by string
    def __str__ (self ):
        s = '\n'.join([ ' '.join([ str (item) for item in row]) for row in self ._rows])
        return s + '\n'
    
    def transpose (self ):
        self .m, self .n = self .n, self .m
        self ._rows = [ list (item) for item in zip (*self ._rows)]
    
    def get_rank (self ):
        return self .m, self .n
    
    #comparable by ==
    def __eq__ (self , mat):
        return mat._rows == self ._rows
    
    #for matrix + matrix
    def __add__ (self , mat):
        if self .get_rank() != mat.get_rank():
            raise Exception ("Trying to add matrixes of varying rank!")
        ret = Matrix( self .m, self .n)
        for x in range (self .m):
            row = [ sum (item) for item in zip (self ._rows[x], mat[x])]
            ret[x] = row
        return ret
    
    #for matrix - matrix
    def __sub__ (self , mat):
        if self .get_rank() != mat.get_rank():
            raise Exception ("Trying to add matrixes of varying rank!")
        ret = Matrix( self .m, self .n)
        for x in range (self .m):
            row = [item[ 0] - item[ 1] for item in zip (self ._rows[x], mat[x])]
            ret[x] = row
        return ret
    
    #for +=
    def __iadd__ (self , mat):
        temp_mat = self + mat
        self ._rows = temp_mat._rows[:]
        return self
    
    #for -=
    def __isub__ (self , mat):
        temp_mat = self - mat
        self._rows = temp_mat._rows[:]
        return self
    
    #for ()
    def __call__(self):
        return "#######\n"+str(self)+"#######\n"
    
m = Matrix(4,4)
print(m())