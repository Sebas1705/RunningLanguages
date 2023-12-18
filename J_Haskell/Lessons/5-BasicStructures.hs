{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use guards" #-}



-- IF
d::Int
d=5
result::Int
result = if d<10 then 10 
            else if d>10 then 20 
            else 30

-- CASE
odd::Int->Int
odd x = case x`mod`2 of
        0 -> 10
        _ -> 20 --Another way

-- Guards:
greater::(Int,Int)->Int
greater (x,y)
        | x > y = x
        | otherwise = y

-- List definitions:
listRanged::[Int]
listRanged = [1..5] -- [1,2,3,4,5]
listStepped::[Int]
listStepped = [1,3..10] -- [1,3,5,7,9]
listInfinite::[Int]
listInfinite = [1,4..] -- [1,4,...]
listChars::[Char]
listChars = ['a'..'z'] -- abcdefghijklmnopqrstuvwxyz
listChained::[Int]
listChained = 1:3:210:[1,23,4] -- [1,3,210,1,23,4]
listConcat::[Int]
listConcat = [1,3,2] ++ [2,0,2] -- [1,3,2,2,0,2]

--List functions
list::[Int]
list = concat [[12,21],[],[123,2,2]]

wordReversed::String
wordReversed = reverse "Hola"

len::Int
len = length wordReversed

headed::Int
headed = head [1,2,3,4]
tailed::[Int]
tailed = tail [1,2,3,4] 

initd::[Int]
initd = init [1,2,3,4]
lasted::Int
lasted=last [1,2,3,4]

taked::[Int]
taked = take 3 [1,2,3,4]
dropped::[Int]
dropped = drop 1 [1,2,3,4]

getted::Int
getted=[1,2,3,4]!!2