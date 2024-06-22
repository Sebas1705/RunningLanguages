module EjerciciosExamen where

    ---- Ficha 1:

    -- Ejercicio 1:
    pertenece :: (Eq a) => a -> [a] -> Bool
    --pertenece n = foldl (\acc x->x==n||acc) False
    pertenece n = foldr (\x acc->x==n||acc) False
    
    -- Ejercicio 2:
    eliminar :: (Eq a) => a -> [a] -> [a]
    --eliminar n = foldl (\acc x->if x==n then acc else acc++[x]) []
    eliminar n = foldr (\x acc->if x==n then acc else [x]++acc) []

    -- Ejercicio 3:
    prodEscalar :: (Num a) => [a] -> [a] -> a
    prodEscalar s1 s2 = foldl (\acc x->acc+x) 0 [ x1*x2 | (x1,x2)<-(zip s1 s2)]

    ---- Ficha 2:

    -- Ejercicio 1:
    type Marca = String
    type Numero = Int
    type Uso = String
    data Calzado = Zapatilla Marca Numero Uso | Bota Marca Numero

    instance Show Calzado where  
        show (Zapatilla m n u) = "Zapatilla de la marca "++m++" del numero "++(show n)++" para "++u
        show (Bota m n) = "Bota de la marca "++m++" del numero "++(show n)
      
    instance Eq Calzado where
        (Bota m1 _) == (Bota m2 _) = m1 == m2
        (Zapatilla m1 _ _) == (Zapatilla m2 _ _) = m1 == m2
        (Bota m1 _) == (Zapatilla m2 _ _) = m1 == m2
        (Zapatilla m1 _ _) == (Bota m2 _) = m1 == m2
    instance Ord Calzado where
        (Bota m1 _) <= (Bota m2 _) = m1 <= m2
        (Zapatilla m1 _ _) <= (Zapatilla m2 _ _) = m1 <= m2
        (Bota m1 _) <= (Zapatilla m2 _ _) = m1 <= m2
        (Zapatilla m1 _ _) <= (Bota m2 _) = m1 <= m2

    orderT :: Ord a => [a] -> [a]
    orderT [] = []
    orderT (x:xs) = orderT menores ++ [x] ++ orderT mayores where 
        menores = [y | y <- xs, y <= x]
        mayores = [y | y <- xs, y > x] 

    -- Ejercicio 2:
    type Nombre = String
    data Version = Vers {
        majorVersion::Int,
        minorVersion::Int
    }
    instance Show Version where
        show a = (show (majorVersion a))++"."++(show (minorVersion a))
    instance Eq Version where
        a == b = minorVersion a == minorVersion b && majorVersion a == majorVersion b
    instance Ord Version where
        a <= b = if majorVersion a > majorVersion b then False else
            if majorVersion a == majorVersion b then minorVersion a <= minorVersion b else True 
    data Libreria = Lib {
        nombre::Nombre,
        version::Version
    } deriving Show
    instance Eq Libreria where
        a == b = nombre a == nombre b
    instance Ord Libreria where 
        a <= b = nombre a <= nombre b

    orderL :: Ord a => [a] -> [a]
    orderL [] = []
    orderL (x:xs) = orderL menores ++ [x] ++ orderL mayores where 
        menores = [y | y <- xs, y <= x]
        mayores = [y | y <- xs, y > x] 

    class Compatible a where
        compatible :: a -> a -> Bool
    instance Compatible Version where
        compatible a b = majorVersion a == majorVersion b
    instance Compatible Libreria where
        compatible a b = nombre a == nombre b && compatible (version a) (version b) 
        
    compatibles :: Libreria -> [Libreria] -> [Libreria]
    compatibles a = foldl (\acc x -> if compatible a x then [x]++acc else acc) [] 

    -- Ficha 3:

    -- Ejercicio 1:
    data Arbol' a = AV' | Rama' (Arbol' a) a (Arbol' a) deriving Show
    p :: Arbol' Int
    p = (Rama' AV' 5 (Rama' AV' 6 AV'))

    insertarArbol :: (Ord a) => Arbol' a -> a -> Arbol' a
    insertarArbol AV' x = Rama' AV' x AV'
    insertarArbol (Rama' i r d) x = if x<=r 
        then (Rama' (insertarArbol i x) r d)
        else (Rama' i r (insertarArbol d x))

    -- Ejercicio 2:
    separar :: String -> (String,String)
    separar = foldl (\(accV,accC) x->if elem x "aeiou" then (accV++[x],accC) else (accV,accC++[x])) ([],[])

    -- Ejercicio 3:
    separarPorPosicion :: String -> (String,String)
    separarPorPosicion s = foldl (\(accI,accP) (p,x)->if ((p `mod` 2) == 0) then (accI,accP++[x]) else (accI++[x],accP)) ([],[]) (zip [0..] s)