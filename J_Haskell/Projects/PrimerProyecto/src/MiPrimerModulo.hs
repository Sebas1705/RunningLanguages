module MiPrimerModulo where
    import Data.Char;

    suma :: Int -> Int -> Int 
    suma x y = x + y

    celsius :: Int -> Int
    celsius x = (x - 32) * 5 `div` 9

    factorial :: Integer -> Integer
    factorial n = if n == 0 then 1 else n * factorial (n - 1)

    fibonacci :: Integer -> Integer
    fibonacci n = if (n == 0 || n == 1) then 1 else fibonacci(n-1)+fibonacci(n-2)
    
    multiploDe :: Integer -> Integer -> Bool
    multiploDe p n = n `mod` p == 0

    esPar :: Integer -> Bool
    esPar = multiploDe 2

    esParString :: Integer -> String
    esParString x = if (x `mod` 2 == 0) then "Par" else "Impar"

    switchType :: Integer -> String
    switchType x = case x of
        1 -> "Distes al 1"
        2 -> "Distes al 2"
        _ -> "No distes ni al 1 ni al 2"

    ejGuardas :: Int -> Int -> Char
    ejGuardas x y 
                | x>y = 'X'
                | otherwise = 'Y'

    order :: (Int,Int) -> (Int,Int)
    order (x,y)
            | x<y = (y,x)
            | otherwise = (x,y)

    --Ejercicio mayores:
    mayor :: Int -> Int -> Int
    mayor x y = if x>=y then x else y

    mayor' :: Int -> Int -> Int -> Int 
    mayor' x y z = mayor x (mayor y z)

    --Soluciones resueltas
    mayorR :: Int -> Int -> Int -> Int
    mayorR x = mayor.mayor x

    mayorR' :: Int -> Int -> Int -> Int
    mayorR' x y = mayor x.mayor y

    ----------------------------------------------------------------

    l1 :: [Int]
    l1 = [1,2,3,4,5,6,7]

    l2 :: [Int]
    l2 = [1,3..10]

    l3 :: [Int]
    l3 = [4..]

    l4 :: [Char]
    l4 = ['a'..'z']

    l5 :: [[Bool]]
    l5 = [[True,False],[False,True]]

    l6 :: [[Int]]
    l6 = [1]:[]

    l7 :: [Int]
    l7 = 1:2:2:3:4:[1..10]

    l8 :: [Int]
    l8 = l2++l2

    l9 :: [Int]
    l9 = concat [[1,3],[-0],[0,2..40]]


    --Ejercicio lista:
    list :: Int -> Int -> [Int]
    list x y = [x+y,x-y,x*y]

    union :: String -> String -> String
    union x y = if length x <= 3 && length y <= 3 then x++y else ""
    ----------------------------------------------------------------
    -- [<Exp> | <cualif1>,<cualif2>,...,<cualifN>,<filter1>,<filter2>,...,<filterN>]
    lc :: [Int]
    lc = [x*4|x <- [1..100],x `mod` 2 == 0]

    lc2 :: [(Int,Int)]
    lc2 = [(x,y)|x<-[1..10],y<-[1..3],y/=2]

    lc3 :: [Int]
    lc3 = [x*x|x<-[1..10],even x]

    -- Ejercicio compresion:
    mayusculas :: String -> String
    mayusculas cad = [ x | x<-cad,isUpper x ]
    
    -- Ejercicio patrones-lista:
    longMenorTres :: String -> Bool
    longMenorTres [] = True
    longMenorTres [_] = True
    longMenorTres [_,_] = True
    longMenorTres _ = False

    longMenorTres' :: String -> Bool
    longMenorTres' (_:_:_:_) = False
    longMenorTres' _ = True

    primeraMayus :: String -> Bool
    primeraMayus (x:_) = isUpper x;
    primeraMayus _ = False;

    primeraA :: String -> Bool
    primeraA (x:_) = x == 'A' || x == 'a';
    primeraA _ = False;

    ordenarStrings :: String -> String -> (String,String)
    ordenarStrings [] s = ([],s);
    ordenarStrings s [] = ([],s);
    ordenarStrings a@(x:_) b@(y:_) = if toLower x <= toLower y then (a,b) else (b,a);

    -- Recuersividad final y no final:

    factorialNoFinal :: Integer -> Integer
    factorialNoFinal x = if x==0 then x else x * factorialNoFinal x-1

    factorialFinal :: Integer -> Integer
    factorialFinal x = fac(x,1);
    fac :: (Integer,Integer) -> Integer 
    fac (x,n) = if x==0 then n else fac(x-1,n*x);
    
    -- Ejercicios recursividad:

    longitudLista :: [Int] -> Int
    longitudLista xs = if xs==[] then 0 else 1+longitudLista (tail xs);  
    
    longitudLista' :: [Int] -> Int
    longitudLista' [] = 0
    longitudLista' (_:xs) = 1 + longitudLista' xs

    longitudLista'' :: [Int] -> Int
    longitudLista'' lista = case lista of
        [] -> 0
        (_:xs) -> 1 + longitudLista'' xs


    apariciones :: String -> Char -> Int
    apariciones [] _ = 0
    apariciones (x:xs) y = if x==y then 1+(apariciones xs y) else (apariciones xs y)

    apariciones' :: String -> Char -> Int
    apariciones' xs y = apar(xs,y,0)
    apar :: (String,Char,Int) -> Int
    apar ([],_,c) = c
    apar ((x:xs),y,c) = if x==y then apar(xs,y,c+1) else apar(xs,y,c) 
    
    sumaLista::[Int]->Int
    sumaLista [] = 0
    sumaLista (x:xs) = x + sumaLista xs

    sumaLista'::[Int]->Int
    sumaLista' xs = sumList (xs,0)
    sumList::([Int],Int)->Int
    sumList ([],c) = c
    sumList ((x:xs),c) = (sumList (xs,x+c))

    -- Plegadores Derecha: foldr op e [a,b,c] -> (a op (b op (c op e)))
    sumaLista'':: [Int] -> Int
    sumaLista'' = foldr (+) 0 

    multLista :: [Int] -> Int
    multLista = foldr (*) 1

    allTrue::[Bool]->Bool
    allTrue = foldr (&&) True

    -- Plegadores Izquierda: foldl op e [a,b,c] -> (((e op a) op b) op c)

    restaLista::[Int]->Int
    restaLista=foldl (-) 3 -- (((3 - a) - b) - ...)
    restaLista'::[Int]->Int
    restaLista'=foldl (-) 3 --(a - (b - (... - 3)))

    -- Expresiones lambda:

    transform::[Int]->[Int]
    transform xs = map (\x->x*2) xs -- lo mismo que pasar *

    invertir::[Int]->[Int]
    invertir=foldr (\x lista->lista++[x]) []

    -- Polimorfismo:
    longitud :: [a] -> Int
    longitud [] = 0
    longitud (_:xs) = 1 + longitud xs

    dosVeces :: (a -> a) -> a -> a
    dosVeces f x = f (f x)
    doble :: Int -> Int
    doble x = x * 2

    mezclar :: [(a,b)] -> [(c,d)] -> [((a,c),(b,d))]
    mezclar [] _ = []
    mezclar _ [] = []
    mezclar ((x1,y1):xs) ((x2,y2):ys) = ((x1,x2),(y1,y2)):mezclar xs ys

    incognita :: (a -> b) -> [a] -> [b]
    incognita _ [] = []
    incognita f (x:xs) = f x:incognita f xs


    ---- Definicion de tipos

    -- Sinonimos:
    type Persona = (String,Int)
    type Edad = Int
    type Precio = Float

    -- Enumerado
    data Color = Rojo | Verde | Azul deriving Show -- Para visualizar en consola
    colorAHex :: Color -> Int;
    colorAHex Rojo = 10;
    colorAHex _ = 0;

    type Nexp = Integer
    type DNI = (Integer,Char)
    type Nota = Float
    type Alumno = (Nexp,DNI,Nota)
    aprobado :: Alumno -> Bool
    aprobado (_,_,x) = x>=5

    -- Union (uno u otro)
    data LetraONumber = Letra Char | Number Int

    -- Producto:
    type Nombre = String
    data Person = Person Nombre Edad deriving Show

    juan :: Person 
    juan = Person "Juan" 17

    esJoven:: Person -> Bool
    esJoven (Person _ x) = x<=20

    data Person' = Person' {nombre::String, edad::Int}
    sebas::Person'
    sebas = Person' {nombre="Sebas",edad=20}

    tocayos:: Person' -> Person' -> Bool
    tocayos p1 p2 = nombre p1 == nombre p2

    data Complejo = Float :- Float deriving Show
    parteReal :: Complejo -> Float
    parteReal (x :- _) = x

    type Radio = Float
    type Lado = Float
    data Forma = Circulo Radio | Rectangulo Lado Lado
    area :: Forma -> Float
    area (Circulo r) = pi * r * r
    area (Rectangulo base altura) = base * altura

    -- Recursivo:
    data Natural = Cero | Suc Natural deriving Show
    esCero :: Natural -> Bool
    esCero Cero = True
    esCero _ = False
    esPar' :: Natural -> Bool
    esPar' Cero = True
    esPar' (Suc x) = not (esPar' x)

    data Expr = Valor Integer
                |Expr :+: Expr
                |Expr :-: Expr
                |Expr :*: Expr deriving Show

    ej1 :: Expr
    ej1 = Valor 5 -- representa el valor 5
    ej2 :: Expr
    ej2 = ej1 :+: Valor 3 -- representa el valor 5 + 3

    -- Polimorfico:

    data Par a = UnPar a a deriving Show

    data Arbol a = AV | Rama (Arbol a) a (Arbol a) deriving Show

    a1::Arbol Integer
    a1 = Rama (Rama (Rama AV 12 AV) 49 (Rama (Rama AV 23 AV) 5 (Rama AV 13 AV)))
        123 --Raiz
        (Rama AV 10 AV)

    -- Rama (Rama (Rama AV 12 AV) 49(Rama (Rama AV 23 AV) 5 (Rama AV 13 AV)))123 (Rama AV 10 AV)

    esHoja :: Arbol a -> Bool
    esHoja (Rama AV _ AV) = True
    esHoja _ = False

    numeroDeHojas :: Arbol a -> Integer
    numeroDeHojas AV = 0
    numeroDeHojas (Rama AV _ AV) = 1
    numeroDeHojas (Rama x1 _ x2) = numeroDeHojas x1 + numeroDeHojas x2 

    -- Nomadas:
    division :: Int -> Int -> Maybe Int
    division _ 0 = Nothing
    division m n = Just (m `div` n)

    --Repaso:

    posicion :: [Int] -> Int -> Maybe Int
    posicion xs x = posicion' xs x 0
    
    posicion' :: [Int] -> Int -> Int -> Maybe Int
    posicion' [] _ _ = Nothing
    posicion' (x:xs) y i = if x==y then Just i else posicion' xs y (i+1)


    arbolesIguales :: (Eq a) => Arbol a -> Arbol a -> Bool
    arbolesIguales AV AV = True
    arbolesIguales (Rama r1 x r2) (Rama r3 y r4) = (arbolesIguales r1 r3) && x==y && (arbolesIguales r2 r4)
    arbolesIguales _ _ = False

    instance Eq (a) => Eq (Arbol a) where
        AV == AV = True
        (Rama r1 x r2) == (Rama r3 y r4) = r1==r3 && x==y &&r2==r4
        _ == _ = False

    menorLista :: (Ord a) => [a] -> Maybe a
    menorLista [] = Nothing
    menorLista [x] = Just x
    menorLista (x:y:xs) = menorLista ((min x y):xs)    

