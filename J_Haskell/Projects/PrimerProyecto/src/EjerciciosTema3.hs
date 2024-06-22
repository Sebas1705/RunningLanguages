module EjerciciosTema3 where
        import Data.Char;

        ---- Ficha 0:

        -- Ejercicio 1:
        componer :: (Int,Int) -> Int
        componer (x,y)
                | x `div` y >= x `mod` y = x `div` y
                | otherwise = x `mod` y

        -- Ejercicio 2:
        sucesor :: Int -> Int
        sucesor x = x + 1

        -- Ejercicio 3:

        cuadruple :: Int -> Int
        cuadruple x = x * 4

        ---- Ficha 1:

        -- Ejercicio 1:  
        ordenadosMenor :: Int -> Int -> Int -> Bool
        ordenadosMenor x y z = x<=y&&y<=z

        -- Ejercicio 2: 
        ordenarTupla :: (Int,Int,Int)->(Int,Int,Int)
        ordenarTupla (x,y,z)
            | x<z&&z<y = (x,z,y)
            | z<x&&x<y = (z,x,y)
            | y<x&&x<z = (y,x,z)
            | y<z&&z<x = (y,z,x)
            | z<y&&y<x = (z,y,x)
            | otherwise = (x,y,z)

        -- Ejercicio 3:
        descomponerReal :: Double -> (Int,Int)
        descomponerReal x = (truncate x,truncate(100*x)-(100*fromInteger(truncate x)));

        -- Ejercicio 4:
        divisores :: Int -> [Int]
        divisores x = [ y | y<-[1..x] , x `mod` y ==0];

        -- Ejercicio 5a:
        esDigito :: Char -> Bool
        esDigito x
                | x<='9'&&x>='0' = True
                | otherwise = False

        -- Ejercicio 5b:
        esDigito' :: Char -> Bool
        esDigito' '0' = True
        esDigito' '1' = True
        esDigito' '2' = True
        esDigito' '3' = True
        esDigito' '4' = True
        esDigito' '5' = True
        esDigito' '6' = True
        esDigito' '7' = True
        esDigito' '8' = True
        esDigito' '9' = True
        esDigito' _ = False

        -- Ejercicio 6:
        esPrimo :: Int -> Bool
        esPrimo x = length (divisores x) <= 2

        -- Ejercicio 7:
        listaPrimosImpares :: [Int] -> [Int]
        listaPrimosImpares xs = [ x | x<-xs , esPrimo x && x `mod` 2 == 1]

        -- Ejercicio 8:
        primosMenorIgual :: Int -> [Int]
        primosMenorIgual x = [ y | y<-[1..x], esPrimo y]

        -- Ejercicio 9:
        codificacionTuplas :: [(Char,Char)] -> String
        codificacionTuplas xc = [ x | (x,y)<-xc,length [ e | e<-['a','e','i','o','u'],e==y]>=1]


        -- Ejercicio 10:
        filtrarTuplas :: [(Int,Int)] -> Int -> [(Int,Int)]
        filtrarTuplas ns n = [ (x,y) | (x,y)<-ns, x`mod`2==1&&x>=n]

        -- Ejercicio 11:
        cuantasPitagoricas :: [(Int,Int,Int)] -> Int
        cuantasPitagoricas ns = length [ (x,y,z) | (x,y,z)<-ns, (x*x)+(y*y)==(z*z)];

        -- Ejercicio 12:
        esMayuscula :: Char -> Bool
        esMayuscula x = x<='Z' && x >= 'A';

        -- Ejercicio 13:
        mayusculasMinusculas :: String -> String
        mayusculasMinusculas xs = [ chr (ord x + (if esMayuscula x then 32 else -32))| x<-xs];

        -- Ejercicio 14:
        listaASCII :: String -> [Int]
        listaASCII xs = [ ord x | x <- xs ]

        -- Ejercicio 15:
        mensajeLista :: [Int] -> String
        mensajeLista xs = "Primer elemento: "++(chr (48 + head xs)):[]++", logitud: "++(chr (48 + length xs)):[];

        -- Ejercicio 16:
        contarMayusculas :: String -> Int
        contarMayusculas xs = length [ x | x <- xs, esMayuscula x];

        ---- Ficha 2:

        -- Ejercicio 1:
        contarApariciones :: String -> Char -> Int
        contarApariciones cs c = length [ x | x<-cs , x==c]

        -- Ejercicio 2:
        manipula3Tuplas :: ((String,Int),(String,Int),(String,Int)) -> (String,String,String)
        manipula3Tuplas ((x,_),(y,_),(z,_)) = (x,y,z)

        -- Ejercicio 3:
        sumaMenor10 :: [Int] -> Bool
        sumaMenor10 (x1:(x2:(x3:(x4:_)))) = (x1+x2+x3+x4)<10
        sumaMenor10 _ = False

        -- Ejercicio 4:
        puntoCardinal :: Char -> String
        puntoCardinal x = case x of
                'N' -> "Norte"
                'S' -> "Sur"
                'E' -> "Este"
                'O' -> "Oeste"
                _ -> "El caracter introducido no pertenece a un punto cardinal"
                

        -- Ejercicio 5:
        todosIguales :: Int -> [Int] -> Bool
        todosIguales x xs = length [ i | i<-xs, i==x] == length xs

        -- Ejercicio 6:
        mesajeFrase :: String -> String
        mesajeFrase [] =" Vacia"
        mesajeFrase s = "La primera letra de la frase "++s++" es '"++[head s]++"' y la ultima letra es '"++[last s]++"'" 

        -- Ejercicio 7:
        clasificarValorEntrada :: Int -> String
        clasificarValorEntrada x
                        | x<10 = "El valor de entrada es menor que 10"
                        | x<=20 = "El valor de entrada es mayor o igual a 10 y menor o igual a 20"
                        | x>20 = "El valor de entrada es mayor que 20"
                        | otherwise = ""

        -- Ejercicio 8:
        amigos :: (Int,Int) -> Bool
        amigos (n1,n2) = (sumArray (divs n1) 0) == n2 && n1 == (sumArray (divs n2) 0)  

        sumArray :: [Int] -> Int -> Int
        sumArray [] n = n
        sumArray (n:ns) x = sumArray ns (x+n)

        divs :: Int -> [Int]
        divs n = [ x | x<-[1..(n-1)], n `mod` x == 0]

        -- Ejercicio 9:
        contarConsonantes :: String -> Int
        contarConsonantes s = length [ x | x<-s, elem (toLower x) "bcdfghjklmnpqrstvwxyz"]

        -- Ejercicio 10:
        listaMersene :: Int -> [Int]
        listaMersene n = take n [ 2^m - 1 | m<-[2..], esPrimo m ]

        -- Ejercicio 11:
        listasIguales :: [Int] -> [Int] -> Bool
        listasIguales xs ys = length xs == length ys && length [ x | x<-xs, y<-ys,x==y] == length xs

        -- Ejercicio 12:
        head' :: [Int] -> Int
        head' [] = 0
        head' (x:_) = x

        -- Ejercicio 13:
        tail' :: [Int] -> [Int]
        tail' [] = []
        tail' (_:xs) = xs

        -- Ejercicio 14:
        mayorDivision :: Int -> Int -> Int
        mayorDivision x y = if (x `div` y)>(x `mod` y) then x `div` y else x `mod` y

        -- Ejercicio 15:
        sumaTipos :: Integer -> Float -> Float
        sumaTipos x y = fromInteger x + y

        -- Ejercicio 16:
        cuadruple' :: Int -> Int
        cuadruple' x = x*4

        -- Ejercicio 17:
        clasificacion :: Int -> String
        clasificacion x
                | x>=5 = "Aprobado"
                | otherwise = "Suspenso"
        
        -- Ejercicio 18:
        cuadrado :: [Int] -> [Int]
        cuadrado xs = [ x*x | x <- xs, x `mod` 2 == 0 ]

        -- Ejercicio 19:
        posicionEnLista :: [Int] -> [(Int,Int)]
        posicionEnLista xs = zip [0..] xs

        -- Ejercicio 20:
        long :: [Int] -> Int
        long xs = sum [ 1 | _<-xs]

        -- Ejercicio 21:
        contiene :: Int -> [Int] -> Bool
        contiene x xs = length [ n | n<-xs, n==x ] >= 1

        -- Ejercicio 22:
        primeros :: [(Char,Int)] -> String
        primeros ts = [ a | (a,_)<-ts ]

        -- Ejercicio 23:
        primerosPares :: [(Char,Int)] -> String
        primerosPares ts = [ a | (a,b)<-ts, b `mod` 2 == 0 ]

        -- Ejercicio 24:
        partir :: Int -> [Int] -> ([Int],[Int])
        partir n ns = (take n ns, drop n ns)

        -- Ejercicio 25:
        insertar :: [Int] -> Int -> Int -> [Int]
        insertar ns n p = (take p ns)++[n]++(drop p ns)

        -- Ejercicio 26:
        codifica :: [Int] -> String
        codifica ns = [ if a `mod` 2 == 0 then 'p' else 'i' | a<-[0..(length ns - 1)]]

        -- Ejercicio 27:
        listaPotencias :: [Int] -> [Int]
        listaPotencias ns = [ x^(length ns - i - 1) | (i,x)<-(zip [0..(length ns - 1)] ns) ]

        -- Ejercicio 28: 
        listaPerfectos :: Int -> [Int] 
        listaPerfectos n = take n [ m | m<-[1..], (sum (init (divisores m)))==m ]

        -- Ejercicio 29:
        listaFermat :: Int -> [Int]
        listaFermat n = take n [ 2^(2*m) + 1 | m<-[0..], esPrimo m ]