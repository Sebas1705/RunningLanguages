
-- Basic types

--Boolean: False or True
boolean :: Bool 
boolean = False
--Operator:
{-
    &&, ||
    not, otherwise
-}

--Char: simple character '..'
character :: Char
character = 'A'
--Operator:
{-
    ==, /=, <, <=, >=, >
    ord, chr, isUpper, isLower, isDigit (Data.Char)
-}

--String: sequence of characters ".."
string :: String
string = "String"

--Int: simple precision integer (-2^31 to 2^31 - 1)
int :: Int
int = 201
--Integer: arbitrary precision integer
integer :: Integer
integer = 102020
--Operator:
{-
    +, -, *, ==, /=, <, <=, >=, >
    `div` , `mod`
    abs, negate, even, odd
-}

--Float: arbitrary precision floating point
float :: Float
float = 2.232e-56
--Double: double precision floating point
double :: Double
double = 2.21223e-2
--Operator:
{-
    +, -, *, /, ==, /=, <, <=, >=, >
    abs, truncate, floor, ceiling, round, fromInteger
-}

--Complex types:

--List: same type list
list :: [Int]
list = [1, 2, 3, 4, 5, 6]

--Tuples: sequence of elements heterogeneous
tuple :: (Double, String)
tuple = (2.2e-1,"Hello")



--Personalized types: create an structure

--Algebraic: create enum of data
data Color = Red | Blue | Green
favoriteColor :: Color
favoriteColor = Red
--Arguments:
data Person = Person {nameP::String,ageP::Int}
person::Person
person = Person {nameP="Sebas", ageP=17}
--Multiple constructor:
data Form = Rectangle Float Float | Circle Float | Square Float
form::Form
form = Rectangle 3.2 2.3

--Optional: value can be absent
age :: Maybe Int
age = Nothing --Just 15

--Two types:
res :: Either String Int
res =  Right 42 --Left "Hi"

--Functions: 
func :: Int -> Int -> Int
func x z = z + 2 + x