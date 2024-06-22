module Main (main) where

    import System.IO
    import System.IO.Unsafe

    type Nombre = String
    type Ciudad = String
    type Pais = String
    type Ocupacion = String
    type Continente = String

    data Personaje = P Nombre Ciudad Pais Ocupacion Continente
    instance Show Personaje where
        show (P n c p o ct) = "\n"++n++", "++c++", "++p++", "++o++", "++ct


    -- Recibe la linea y el delimitador
    partirLinea :: String -> Char -> [String]
    partirLinea linea d = partirLineaAux linea d [] []

    partirLineaAux :: String -> Char -> String -> [String] -> [String]
    partirLineaAux [] _ _ ac = ac
    partirLineaAux (x:xs) d palabra ac = if (x==d) then 
        partirLineaAux xs d [] ac ++ [palabra] 
        else partirLineaAux xs d (palabra++[x]) ac

    leerEntrada :: IO [String]
    leerEntrada = do
        contenido <- readFile "database.csv"
        let todoTasks = lines contenido
        return todoTasks

    lineas :: [String]
    lineas = unsafePerformIO (leerEntrada)

    personajes :: [String] -> [Personaje]
    personajes l = foldr (\x acc -> [x]++acc) [] [ P (y!!11) (y!!8) (y!!7) (y!!5) (y!!6) | n<-l , let y = partirLinea n ';' ]

    filosofos :: [Personaje] -> [Personaje]
    filosofos ps =  filter (\(P _ _ _ o _)->o=="Philosopher") ps

    griegos :: [Personaje] -> [Personaje]
    griegos ps = filter (\(P _ _ p _ _)->p=="Greece") ps

    filosofosYEuropeos :: [Personaje] -> [Personaje]
    filosofosYEuropeos ps = filter (\(P _ _ _ o ct)->o=="Philosopher"&&ct=="Europe") ps
    
    main = do
        let lineasPers = drop 1 lineas
        let ps = personajes lineasPers
        print(filosofosYEuropeos ps)
