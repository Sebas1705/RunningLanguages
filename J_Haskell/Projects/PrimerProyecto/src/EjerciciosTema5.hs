module EjerciciosTema5 where

    ---- Ficha 1:

    -- Ejercicio 1:
    type Nombre = String
    type Edad = Integer
    type Persona = (Nombre, Edad)

    descuentoAbono :: Persona -> Bool
    descuentoAbono (_,x) = x>=65 || x<=22

    -- Ejercicio 2:
    type DNI = String
    type Exp = Int
    type PD = Double
    type Alumno = (DNI,Exp,PD)

    aprobado5 :: Alumno -> Bool
    aprobado5 (_,_,x) = x>=5

    calificacionAlumno :: Alumno -> String
    calificacionAlumno (_,e,n) = "Expediente:"++(show e)++", Nota Acta:"++(fNota n) where
        fNota x 
            | x<5 = "Suspenso"
            | x<7 = "Bien"
            | x<9 = "Notable"
            | otherwise = "Sobresaliente"

    dameNota :: Alumno -> Double
    dameNota (_,_,n) = n

    mediaNotas :: [Alumno] -> Double
    mediaNotas [] = 0
    mediaNotas x = (sumNotas x)/(fromIntegral (length x)) where
        sumNotas [] = 0
        sumNotas ((_,_,n):xs) = n + (sumNotas xs)

    -- Ejercicio 3:
    data Alumno' = Alm DNI Exp PD deriving Show 

    aprobado5' :: Alumno' -> Bool
    aprobado5' (Alm _ _ n) = n>=5

    calificacionAlumno' :: Alumno' -> String
    calificacionAlumno' (Alm _ e n) = "Expediente:"++(show e)++", Nota Acta:"++(fNota n) where
        fNota x 
            | x<5 = "Suspenso"
            | x<7 = "Bien"
            | x<9 = "Notable"
            | otherwise = "Sobresaliente"

    dameNota' :: Alumno' -> Double
    dameNota' (Alm _ _ n) = n

    mediaNotas' :: [Alumno'] -> Double
    mediaNotas' [] = 0
    mediaNotas' x = (sumNotas x)/(fromIntegral (length x)) where
        sumNotas [] = 0
        sumNotas ((Alm _ _ n):xs) = n + (sumNotas xs)

    -- Ejercicio 4:
    data Alumno'' = Almuno {
        dni :: String,
        expediente :: Int,
        pdNota :: Double
    }

    aprobado5'' :: Alumno'' -> Bool
    aprobado5'' a = (pdNota a)>=5

    calificacionAlumno'' :: Alumno'' -> String
    calificacionAlumno'' a = "Expediente:"++(show (expediente a))++", Nota Acta:"++(fNota (pdNota a)) where
        fNota x 
            | x<5 = "Suspenso"
            | x<7 = "Bien"
            | x<9 = "Notable"
            | otherwise = "Sobresaliente"

    dameNota'' :: Alumno'' -> Double
    dameNota'' a = pdNota a

    mediaNotas'' :: [Alumno''] -> Double
    mediaNotas'' [] = 0
    mediaNotas'' x = (sumNotas x)/(fromIntegral (length x)) where
        sumNotas [] = 0
        sumNotas (a:xs) = (pdNota a) + (sumNotas xs)

    -- Ejercicio 5:
    data Complejo = Com Float Float deriving Show 

    parteReal :: Complejo -> Float
    parteReal (Com x _) = x

    sumaComplejos :: Complejo -> Complejo -> Complejo
    sumaComplejos (Com x1 x2) (Com y1 y2) = (Com (x1+y1) (x2+y2))

    -- Ejercicio 6:
    type Racional = (Int,Int)

    equivalentes :: Racional -> [Racional] -> [Racional]
    equivalentes (a,b) xs = [ (x,y) | (x,y)<-xs, a*y==b*x]

    
                   