module EjerciciosTema4 where

    ---- Ficha 1:

    -- Ejercicio 1:
    cribar :: [Integer] -> Integer -> [Integer]
    cribar xs x = [ n | n <- xs , n `mod` x /= 0]

    -- Ejercicio 2:
    ceros :: [Int] -> Int
    ceros [] = 0
    ceros (0:xs) = 1 + ceros xs
    ceros (_:xs) = ceros xs 
    
    -- Ejercicio 3:
    repeticiones :: [Int] -> ([Int],[Int])
    repeticiones [] = ([],[])
    repeticiones xs = repeticiones' xs ([],[])

    repeticiones' :: [Int] -> ([Int],[Int]) -> ([Int],[Int])
    repeticiones' [] x = x
    repeticiones' (n:ns) (nrs,rs) = if elem n nrs  
        then repeticiones' ns (borrarElemento n nrs,if elem n rs then rs else rs++[n]) 
        else if notElem n rs then repeticiones' ns (nrs++[n],rs) else repeticiones' ns (nrs,rs)

    borrarElemento :: Int -> [Int] -> [Int]
    borrarElemento _ [] = []
    borrarElemento e (x:xs) =
        if e == x then xs
        else x : borrarElemento e xs

    -- Ejercicio 4:
    incluye :: [Int] -> [Int] -> Bool
    incluye [] _ = True
    incluye _ [] = False
    incluye (x:xs) ys = elem x ys && incluye xs ys

    -- Ejercicio 5:
    sumaCifras :: Int -> Int
    sumaCifras x = if x<10 then x else (x `mod` 10) + sumaCifras (x `div` 10)

    -- Ejercicio 6:
    contieneCifra :: Int -> Int -> Bool
    contieneCifra x s
        | s<10 = x==s
        | x==(s `mod` 10) = True 
        | otherwise = contieneCifra x (s `div` 10) 

    -- Ejercicio 7:
    invertir' :: Int -> Int
    invertir' x = read (reverse (show x))

    -- Ejercicio 8:
    eliminarUltimos :: Int -> [Int] -> [Int]
    eliminarUltimos x xs = eliminar x (reverse xs) [] 
        where 
            eliminar _ [] acc = reverse acc
            eliminar m (y:ys) acc
                | m<=0 = eliminar m ys (acc++[y])
                | otherwise = eliminar (m-1) ys acc


    -- Ejercicio 9:
    listaOrdenada :: [Int] -> Bool
    listaOrdenada [] = True
    listaOrdenada [_] = True
    listaOrdenada (x:y:xs) = x<=y && listaOrdenada (y:xs)

    ---- Ficha 2:

    -- Ejercicio 1:
    -- \x -> x + x

    -- Ejercicio 2:
    sumaDobles :: [Int] -> Int
    sumaDobles = foldr (\x y -> x*2 + y) 0

    -- Ejercicio 3:
    sumaCuadradosPares :: [Int] -> Int 
    sumaCuadradosPares xs = foldr (\x y -> x*x + y) 0 (filter (\x -> x `mod` 2 == 0) xs) 

    -- Ejercicio 4:
    eliminaValor :: Int -> [Int] -> [Int]
    eliminaValor n ns = foldr (\x acc -> if x==n then acc else [x]++acc ) [] ns

    -- Ejercicio 5: 
    eliminaDuplicados :: [Int] -> [Int]
    eliminaDuplicados = foldl (\acc x -> if notElem x acc then acc++[x] else acc) [] 

    -- Ejercicio 6:
    listaPrimos :: [Int] -> [Int]
    listaPrimos = filter (\x -> length [ y | y<-[1..x] , x `mod` y ==0] <= 2)

    ---- Ficha 3:

    -- Ejercicio 1:
    mezclarEnTernas :: [a] -> [b] -> [(a,b,b)]
    mezclarEnTernas (x:xs) (y1:y2:ys) = (x,y1,y2) : mezclarEnTernas xs ys
    mezclarEnTernas _ _ = []

    -- Ejercicio 2:
    alFinal :: a -> [a] -> [a]
    alFinal n = foldr (\x acc -> [x]++acc) [n] 

    -- Ejercicio 3:
    takeWhile' :: (a -> Bool) -> [a] -> [a]
    takeWhile' f xs = filter f xs

    -- Ejercicio 4:
    posicionesElem :: Eq a => (a, [a]) -> [Int]
    posicionesElem (x, xs) = reverse (foldl (\acc (idx, y) -> if x == y then idx : acc else acc) [] (zip [0..] xs))

    -- Ejercicio 5:
    contiene :: Eq a => a -> [a] -> Bool
    contiene e xs = foldl (\acc x -> acc || (x == e)) False xs   


