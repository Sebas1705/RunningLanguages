package com.sebss.pass_word.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sebss.pass_word.data.dao.PlayerDao
import com.sebss.pass_word.data.dao.WordDao
import com.sebss.pass_word.data.entities.PlayerEntity
import com.sebss.pass_word.data.entities.WordEntity
import com.sebss.pass_word.data.typeconvertors.DefinitionConverter
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Database(
    entities = [PlayerEntity::class, WordEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DefinitionConverter::class)
abstract class AppDatabase : RoomDatabase() {

    //Dao's:
    abstract fun playerDao(): PlayerDao
    abstract fun wordDao(): WordDao

    //Constructor -Singleton-
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        @OptIn(DelicateCoroutinesApi::class)
        private fun buildDatabase(context: Context): AppDatabase {
            Log.d("DB", "DATABASE BUILD INIT")
            val databaseBuilder = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "Pass_Word_DB"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //Init insert data (default data)
                        GlobalScope.launch {
                            Log.d("BD", "CALLBACK INIT")
                            insertInitialData(getInstance(context))
                            Log.d("BD", "CALLBACK END")
                        }
                    }
                })
                .build()
            Log.d("DB", "DATABASE BUILD END")
            return databaseBuilder
        }

        private suspend fun insertInitialData(database: AppDatabase) {
            val words = arrayListOf<WordEntity>(
                WordEntity(
                    "Perro",

                    arrayListOf(
                        "Mamífero doméstico de la familia de los cánidos, de tamaño, forma y pelaje muy diversos, según las razas, que tiene olfato muy fino y es inteligente y muy leal a su dueño.",
                        "Persona despreciable",
                        "Mal o daño que se ocasiona a alguien al engañarle en un acuerdo o pacto.",
                        "Hombre tenaz, firme y constante en alguna opinión o empresa.",
                        "Tanto o piedra pequeña del juego del león."
                    )
                ),
                WordEntity(
                    "Gato",

                    arrayListOf(
                        "Mamífero carnívoro de la familia de los felinos, digitígrado, doméstico, de pelo suave y gato salvaje, de mayor tamaño, de pelaje espeso y cola larga.",
                        "Hombre astuto y disimulado.",
                        "Instrumento musical formado por una serie de cuerdas percutidas o raspadas.",
                        "Rincón o lugar de algo.",
                        "Tirada corta de una piedra u otra cosa."
                    )
                ),
                WordEntity(
                    "Árbol",

                    arrayListOf(
                        "Planta perenne, de tallo leñoso, que se ramifica a cierta altura del suelo.",
                        "Representación gráfica de las relaciones de parentesco, profesionales, de organización, etc.",
                        "Esquema que representa las relaciones de parentesco entre los miembros de una familia.",
                        "Conjunto de elementos que forman una estructura.",
                        "En matemáticas, estructura jerárquica que representa las relaciones de parentesco entre los elementos de un conjunto."
                    )
                ),
                WordEntity(
                    "Silla",

                    arrayListOf(
                        "Asiento con respaldo, por lo común con cuatro patas, para una persona.",
                        "Cargo o dignidad de presidente de una entidad, comisión, tribunal, etc.",
                        "En ciertos juegos de naipes, jugada que consiste en tener en la mano todas las cartas de un palo.",
                        "Pequeña embarcación de vela ligera, generalmente sin motor.",
                        "Vuelo o carrera corta de un pájaro o insecto."
                    )
                ),
                WordEntity(
                    "Cielo",

                    arrayListOf(
                        "Esfera aparente azul que rodea la Tierra, donde se encuentran las nubes y fenómenos atmosféricos.",
                        "Paraíso, lugar de felicidad suprema.",
                        "Conjunto de las regiones más elevadas del aire.",
                        "Color azul claro.",
                        "Lugar muy alto."
                    )
                ),
                WordEntity(
                    "Manzana",

                    arrayListOf(
                        "Fruto del manzano, de forma redonda o ligeramente aplastada, de piel fina, carne generalmente blanca o amarilla y con varias semillas negras en su interior.",
                        "Pomarada, conjunto de manzanos.",
                        "Pequeña eminencia o protuberancia que se forma en algunas superficies.",
                        "Cabeza.",
                        "Proyectil de pequeño calibre que se arroja con la mano."
                    )
                ),
                WordEntity(
                    "Elefante",

                    arrayListOf(
                        "Mamífero paquidermo de gran tamaño, piel gruesa, orejas grandes y colmillos largos y curvos.",
                        "Persona muy corpulenta.",
                        "Pieza más fuerte y gruesa de un hueso largo.",
                        "Pieza de madera que se coloca verticalmente para sostener algo.",
                        "Instrumento musical de viento."
                    )
                ),
                WordEntity(
                    "Mariposa",

                    arrayListOf(
                        "Insecto volador de cuerpo delicado y alas coloreadas.",
                        "Persona inconstante o voluble.",
                        "Figura de la gimnasia artística que consiste en dar una vuelta completa en el aire sin soltar la barra.",
                        "Cinta adhesiva que se utiliza para sellar cajas, paquetes, etc.",
                        "Planta ornamental de flores llamativas y coloridas."
                    )
                ),
                WordEntity(
                    "Delfín",

                    arrayListOf(
                        "Mamífero marino, carnívoro, de cuerpo alargado, hocico largo y aleta dorsal.",
                        "Persona que destaca en una disciplina artística, científica o deportiva.",
                        "En náutica, cabo o cuerda que se afirma por un extremo al palo de la nave y por el otro a una driza.",
                        "Tipo de estribo que se coloca a media altura en la jarcia de un palo, sirviendo de punto de apoyo para el aparejo.",
                        "Tipo de ancla pequeña utilizada en botes."
                    )
                ),
                WordEntity(
                    "Jirafa",

                    arrayListOf(
                        "Mamífero rumiante de cuello largo y patas largas, con manchas irregulares en su pelaje.",
                        "Persona de gran altura.",
                        "Instrumento para medir alturas o distancias inaccesibles.",
                        "Estructura metálica para el transporte de personas o materiales a alturas elevadas.",
                        "Flecha que cae verticalmente."
                    )
                ),
                WordEntity(
                    "Nube",

                    arrayListOf(
                        "Conjunto visible de partículas acuosas o de hielo en la atmósfera.",
                        "Desvanecimiento temporal de la vista.",
                        "Agrupación de elementos dispersos.",
                        "En informática, servicio de almacenamiento y procesamiento de datos en línea.",
                        "Mancha oscura y redonda en la piel."
                    )
                ),
                WordEntity(
                    "Tigre",

                    arrayListOf(
                        "Gran felino carnívoro de pelaje anaranjado y rayas negras.",
                        "Persona valiente y arrojada.",
                        "Aparato o máquina que se utiliza para doblar o dar forma a objetos metálicos.",
                        "Tipo de caza que se realiza con arco y flechas.",
                        "Persona astuta y de malas intenciones."
                    )
                ),
                WordEntity(
                    "Luna",

                    arrayListOf(
                        "Satélite natural de la Tierra que refleja la luz del Sol durante la noche.",
                        "Cuerpo celeste que gira alrededor de un planeta.",
                        "Persona de gran belleza.",
                        "Cuerpo redondeado y luminoso de ciertos insectos.",
                        "Objeto en forma de media luna."
                    )
                ),
                WordEntity(
                    "Cuchillo",

                    arrayListOf(
                        "Instrumento cortante formado por una hoja de acero y un mango.",
                        "Tipo de nudo marinero.",
                        "Punta afilada de algunos objetos.",
                        "Tipo de lámina de herramientas cortantes.",
                        "Objeto afilado utilizado en la cocina."
                    )
                ),
                WordEntity(
                    "Zorro",

                    arrayListOf(
                        "Mamífero carnívoro de la familia de los cánidos, de pelaje rojizo y cola espesa.",
                        "Persona astuta y mañosa.",
                        "Aparato para deshacerse de malos olores.",
                        "Persona con gran habilidad o destreza.",
                        "Jugador hábil y astuto."
                    )
                ),
                WordEntity(
                    "Océano",

                    arrayListOf(
                        "Extensión muy amplia de agua salada que cubre la mayor parte de la superficie terrestre.",
                        "Grandeza y amplitud de algo.",
                        "Conjunto de seres o cosas innumerables.",
                        "En poesía, grandeza y profundidad del alma.",
                        "Energía y poder impresionante."
                    )
                ),
                WordEntity(
                    "Fuego",

                    arrayListOf(
                        "Proceso de combustión con desprendimiento de llamas y calor.",
                        "En la mitología, uno de los cuatro elementos básicos.",
                        "Conjunto de disparos de armas de fuego.",
                        "Entusiasmo o pasión.",
                        "En ciertos juegos, conjunto de cartas iguales."
                    )
                ),
                WordEntity(
                    "Quetzal",

                    arrayListOf(
                        "Ave de brillantes colores que habita en América Central.",
                        "Unidad monetaria de Guatemala.",
                        "Dios azteca de la sabiduría y del viento.",
                        "Joya de jade tallada en forma de serpiente emplumada.",
                        "Árbol de la familia de las Lauráceas, cuya corteza se utiliza medicinalmente."
                    )
                ),
                WordEntity(
                    "Espejo",

                    arrayListOf(
                        "Superficie pulida que refleja la luz.",
                        "Herramienta para observar el aspecto físico.",
                        "Aparato que refleja o reproduce una imagen.",
                        "Conjunto de características que reflejan una situación o realidad.",
                        "En náutica, pequeño reflector de luz."
                    )
                ),
                WordEntity(
                    "Fénix",

                    arrayListOf(
                        "Ave fabulosa que renace de sus cenizas.",
                        "Persona que resurge de las dificultades.",
                        "En mitología, símbolo de la inmortalidad y la renovación.",
                        "Nombre de varias constelaciones.",
                        "En alquimia, símbolo del fuego purificador."
                    )
                ),
                WordEntity(
                    "Globo",

                    arrayListOf(
                        "Objeto esférico lleno de gas o aire y sujeto por una cuerda.",
                        "Representación gráfica de la Tierra.",
                        "Esfera transparente que contiene líquido y una figura.",
                        "Pelota pequeña y liviana.",
                        "Hinchazón o inflamación en alguna parte del cuerpo."
                    )
                ),
                WordEntity(
                    "Xilófono",

                    arrayListOf(
                        "Instrumento musical de percusión compuesto por láminas de madera de diferentes tamaños.",
                        "Conjunto de láminas metálicas afinadas que se tocan con mazos.",
                        "Persona que toca el xilófono.",
                        "En zoología, conjunto de piezas bucales de algunos insectos.",
                        "En tipografía, máquina compuesta de cajas con letras de imprenta."
                    )
                ),
                WordEntity(
                    "Quasar",

                    arrayListOf(
                        "Fuente astronómica de energía electromagnética, extremadamente distante y luminosa.",
                        "En informática, sistema de búsqueda y recuperación de información.",
                        "En matemáticas, símbolo algebraico.",
                        "Nombre de un personaje en la serie de cómics Marvel.",
                        "Nombre de varios videojuegos."
                    )
                ),
                WordEntity(
                    "Zambullida",

                    arrayListOf(
                        "Acción de lanzarse o sumergirse en el agua de cabeza.",
                        "Acto de sumergirse o introducirse en algo.",
                        "En argot, robo rápido y sorpresivo.",
                        "Maniobra militar de descenso rápido en paracaídas.",
                        "Buceo realizado por aves acuáticas."
                    )
                ),
                WordEntity(
                    "Orquídea",

                    arrayListOf(
                        "Planta ornamental de la familia de las orquidáceas.",
                        "Cualquier planta de esta familia.",
                        "Flor de estas plantas.",
                        "En zoología, apéndice en forma de labio de ciertos moluscos.",
                        "Tumor o bulto en forma de testículo."
                    )
                ),
                WordEntity(
                    "Violín",

                    arrayListOf(
                        "Instrumento musical de cuerda frotada.",
                        "En zoología, apéndice alargado de ciertos moluscos.",
                        "En anatomía, parte del oído interno en forma de espiral.",
                        "Objeto largo y delgado que se asemeja a un violín.",
                        "En arquitectura, ménsula en forma de S que sostiene un balcón."
                    )
                ),
                WordEntity(
                    "Amapola",

                    arrayListOf(
                        "Planta herbácea con flores de pétalos sedosos y rojos.",
                        "Flor de esta planta.",
                        "En náutica, clavija con que se asegura un grillete.",
                        "En geología, tipo de roca.",
                        "Tipo de seda natural."
                    )
                ),
                WordEntity(
                    "Halcón",

                    arrayListOf(
                        "Ave rapaz de pico ganchudo y alas largas y puntiagudas.",
                        "Persona astuta y observadora.",
                        "Coche deportivo de la marca Ford.",
                        "En arquería, flecha larga.",
                        "Nombre de varios modelos de cohetes espaciales."
                    )
                ),
                WordEntity(
                    "Yogur",

                    arrayListOf(
                        "Producto lácteo obtenido por fermentación bacteriana.",
                        "En gastronomía, postre hecho con yogur.",
                        "Persona a la que le gusta el yogur.",
                        "En meteorología, viento que sopla del noroeste al sureste.",
                        "Unidad de medida de la presión atmosférica."
                    )
                ),
                WordEntity(
                    "Kiosco",

                    arrayListOf(
                        "Puesto pequeño y abierto para vender periódicos, revistas, etc.",
                        "Edificio pequeño de forma hexagonal o octogonal.",
                        "En informática, interfaz gráfica de usuario para acceder a servicios en línea.",
                        "Tipo de construcción en la antigua Grecia.",
                        "Establecimiento que vende helados y refrescos."
                    )
                ),
                WordEntity(
                    "Ñandú",

                    arrayListOf(
                        "Ave no voladora de América del Sur, similar al avestruz.",
                        "En Argentina, tonto o torpe.",
                        "En botánica, planta de la familia de las solanáceas.",
                        "En zoología, cangrejo de río.",
                        "Instrumento de percusión."
                    )
                ),
                WordEntity(
                    "Ukelele",

                    arrayListOf(
                        "Instrumento musical de cuerda pulsada, similar a la guitarra.",
                        "En jerga, persona inexperta en algo.",
                        "En geografía, isla pequeña.",
                        "En informática, plataforma de desarrollo.",
                        "Técnica de entrenamiento en artes marciales."
                    )
                ),
                WordEntity(
                    "Zafiro",

                    arrayListOf(
                        "Gema preciosa de color azul.",
                        "Color azul intenso.",
                        "Tipo de vidrio resistente al fuego.",
                        "Nombre de varios barcos.",
                        "Tipo de láser utilizado en medicina y tecnología."
                    )
                ),
                WordEntity(
                    "Invierno",

                    arrayListOf(
                        "Estación del año caracterizada por bajas temperaturas.",
                        "Época fría del año.",
                        "Período difícil o desfavorable.",
                        "Momento en que algo está en su apogeo o máxima intensidad.",
                        "En meteorología, fecha en la que comienza el invierno."
                    )
                ),
                WordEntity(
                    "Dorado",

                    arrayListOf(
                        "De color dorado o parecido al oro.",
                        "Color obtenido mezclando amarillo y blanco.",
                        "Objeto recubierto con una capa de oro.",
                        "En pesca, tipo de pescado.",
                        "En la mitología, color de la piel de ciertos seres míticos."
                    )
                ),
                WordEntity(
                    "Hormiga",

                    arrayListOf(
                        "Insecto social que vive en colonias.",
                        "Persona trabajadora y diligente.",
                        "En astronomía, sistema estelar triple.",
                        "En zoología, nombre de varios tipos de insectos.",
                        "En informática, tipo de software malicioso."
                    )
                ),
                WordEntity(
                    "Lince",

                    arrayListOf(
                        "Mamífero carnívoro de la familia de los felinos, de tamaño mediano.",
                        "Persona con gran agudeza visual o auditiva.",
                        "Tipo de punto en tejido.",
                        "En náutica, aparejo para arriar velas.",
                        "Nombre de varios modelos de automóviles."
                    )
                ),
                WordEntity(
                    "Búho",

                    arrayListOf(
                        "Ave rapaz nocturna de ojos grandes y plumaje suave.",
                        "Persona sabia y reflexiva.",
                        "Tipo de lámpara con forma de búho.",
                        "En la mitología, ave asociada con la sabiduría.",
                        "En náutica, extremo superior de la popa de una embarcación."
                    )
                ),
                WordEntity(
                    "Faro",

                    arrayListOf(
                        "Torre alta con luz en la parte superior para guiar a las embarcaciones.",
                        "Señal luminosa en la proa de una aeronave.",
                        "En zoología, parte saliente del caparazón de algunos crustáceos.",
                        "En arquitectura, estructura elevada para iluminación.",
                        "En geografía, lugar elevado con vistas panorámicas."
                    )
                ),
                WordEntity(
                    "Pirámide",

                    arrayListOf(
                        "Estructura arquitectónica de forma triangular, con una base y cuatro caras.",
                        "En geometría, poliedro de base cuadrangular y caras triangulares.",
                        "En nutrición, representación gráfica de una dieta equilibrada.",
                        "En astronomía, grupo de estrellas que forman un patrón triangular.",
                        "En ecología, representación de la jerarquía alimentaria en un ecosistema."
                    )
                ),
                WordEntity(
                    "Platillo",

                    arrayListOf(
                        "Objeto plano utilizado para sostener alimentos.",
                        "En música, plato metálico que se golpea para producir sonido.",
                        "En deportes, objeto volador utilizado en ciertos juegos.",
                        "En cocina, preparación culinaria que acompaña al plato principal.",
                        "En ufología, objeto volador no identificado de forma circular."
                    )
                ),
                WordEntity(
                    "Rayo",

                    arrayListOf(
                        "Descarga eléctrica producida durante una tormenta.",
                        "Línea de luz que se desplaza en línea recta.",
                        "En mecánica, elemento estructural que soporta carga en una dirección.",
                        "En mitología, arma de los dioses que produce destellos de luz.",
                        "En deportes, velocidad en una carrera o competición."
                    )
                ),
                WordEntity(
                    "Esmeralda",

                    arrayListOf(
                        "Gema preciosa de color verde intenso.",
                        "Color verde intenso similar al de la esmeralda.",
                        "Nombre de varias plantas con flores de color verde.",
                        "En mitología, piedra mágica asociada a la sabiduría.",
                        "En literatura, personaje femenino con ojos verdes intensos."
                    )
                ),
                WordEntity(
                    "Rincón",

                    arrayListOf(
                        "Ángulo formado por dos superficies que se encuentran.",
                        "Lugar apartado o escondido.",
                        "En gastronomía, pequeña porción de un alimento.",
                        "En arquitectura, adorno en la parte superior de un edificio.",
                        "En literatura, tema recurrente en una obra o género."
                    )
                ),
                WordEntity(
                    "Sirena",

                    arrayListOf(
                        "Criatura mitológica con parte superior humana y parte inferior de pez.",
                        "En náutica, señal sonora para alertar peligro.",
                        "En automovilismo, alarma audible de un vehículo.",
                        "En tecnología, dispositivo de alarma sonora.",
                        "En música, mujer que canta con voz muy melodiosa."
                    )
                ),
                WordEntity(
                    "Xenón",

                    arrayListOf(
                        "Elemento químico noble de la tabla periódica.",
                        "Gas incoloro e inodoro utilizado en lámparas.",
                        "Tipo de láser utilizado en cirugía oftálmica.",
                        "En tecnología de iluminación, gas utilizado en proyectores.",
                        "En medicina, gas utilizado en anestesia."
                    )
                ),
                WordEntity(
                    "Sol",

                    arrayListOf(
                        "Estrella central del sistema solar.",
                        "Fuente de luz y calor para la Tierra.",
                        "En música, la nota más alta de una escala.",
                        "Persona que destaca y brilla en su campo.",
                        "En náutica, la parte superior de la entena mayor de un barco."
                    )
                ),
                WordEntity(
                    "Eclipse",

                    arrayListOf(
                        "Fenómeno astronómico en el que un astro se oculta total o parcialmente por otro.",
                        "En literatura, ocultación temporal de una obra o autor.",
                        "En medicina, pérdida temporal de conocimiento.",
                        "En informática, herramienta para ocultar código fuente.",
                        "En música, variación o cambio en la interpretación de una obra."
                    )
                ),
                WordEntity(
                    "Lluvia",

                    arrayListOf(
                        "Precipitación atmosférica en forma de gotas de agua.",
                        "En abundancia o gran cantidad de algo.",
                        "En música, serie rápida de notas sucesivas.",
                        "En amor, manifestación de cariño y afecto.",
                        "En poesía, símbolo de melancolía y tristeza."
                    )
                ),
                WordEntity(
                    "Universo",

                    arrayListOf(
                        "Conjunto de todo lo que existe, incluyendo la materia, el espacio y el tiempo.",
                        "Serie de mundos o sistemas interconectados.",
                        "En filosofía, el todo considerado en su totalidad.",
                        "En astrofísica, el espacio-tiempo y su contenido.",
                        "En teología, la totalidad de la creación divina."
                    )
                ),
                WordEntity(
                    "Guitarra",

                    arrayListOf(
                        "Instrumento musical de cuerda pulsada.",
                        "En zoología, placa ósea en la boca de algunas especies de peces.",
                        "Mueble o estructura de madera en forma de guitarra.",
                        "Tipo de figura geométrica utilizada en arquitectura.",
                        "En construcción, soporte en forma de guitarra para sostener elementos."
                    )
                ),
                WordEntity(
                    "Trébol",

                    arrayListOf(
                        "Planta de hojas trifoliadas.",
                        "Símbolo de buena suerte o fortuna.",
                        "En naipes, una de las cuatro figuras del juego de cartas.",
                        "En botánica, género de plantas herbáceas.",
                        "Tipo de nudo utilizado en escalada y montañismo."
                    )
                ),
                WordEntity(
                    "Río",

                    arrayListOf(
                        "Corriente de agua continua y más o menos caudalosa que fluye hacia un mar, lago u otro río.",
                        "En geografía, término que indica flujo constante o sucesión continua.",
                        "En música, movimiento rápido y fluido de una composición.",
                        "En astronomía, término para describir líneas de estrellas en la Vía Láctea.",
                        "En poesía, metáfora de la corriente de la vida."
                    )
                ),
                WordEntity(
                    "Estrellas",

                    arrayListOf(
                        "Cuerpos celestes luminosos en el cielo nocturno.",
                        "Personas destacadas y famosas.",
                        "En gastronomía, figuras de masa hojaldrada rellenas de crema o frutas.",
                        "Emblemas con puntas radiantes que simbolizan la divinidad.",
                        "En matemáticas, figuras con puntas que se forman al unir vértices de polígonos."
                    )
                ),
                WordEntity(
                    "Huesos",

                    arrayListOf(
                        "Partes duras y resistentes que forman el esqueleto de los vertebrados.",
                        "En gastronomía, partes del esqueleto de los animales utilizadas para hacer caldos.",
                        "En anatomía, cada una de las piezas que forman el cráneo.",
                        "En paleontología, restos fósiles de animales vertebrados.",
                        "Materiales duros y resistentes que forman parte de ciertos objetos."
                    )
                ),
                WordEntity(
                    "Montañas",

                    arrayListOf(
                        "Elevaciones naturales y considerables del terreno.",
                        "En geografía, masas elevadas de tierra con cumbres y laderas pronunciadas.",
                        "En náutica, masas de agua elevadas y agitadas.",
                        "En música, intervalos ascendentes de tres tonos.",
                        "En gastronomía, postres elaborados en capas con diferentes ingredientes."
                    )
                ),
                WordEntity(
                    "Nubes",

                    arrayListOf(
                        "Conjuntos de partículas acuosas suspendidas en la atmósfera.",
                        "Estados de confusión o incertidumbre.",
                        "En informática, plataformas de almacenamiento y procesamiento en línea.",
                        "En anatomía, formaciones de células en superficies.",
                        "En náutica, manchas en el aparejo de una embarcación."
                    )
                ),
                WordEntity(
                    "Árboles",

                    arrayListOf(
                        "Plantas perennes de tallo leñoso y ramificado.",
                        "Representaciones gráficas de relaciones jerárquicas o de parentesco.",
                        "Esquemas que representan relaciones familiares.",
                        "En matemáticas, estructuras jerárquicas de conjuntos.",
                        "En informática, estructuras de datos con nodos y ramas."
                    )
                ),
                WordEntity(
                    "Océanos",

                    arrayListOf(
                        "Extensiones muy amplias de agua salada que cubren la mayor parte de la superficie terrestre.",
                        "Grandezas y amplitudes de algo.",
                        "Conjuntos de seres o cosas innumerables.",
                        "En poesía, grandeza y profundidad del alma.",
                        "Energías y poderes impresionantes."
                    )
                ),
                WordEntity(
                    "Fuegos",

                    arrayListOf(
                        "Procesos de combustión con desprendimiento de llamas y calor.",
                        "En la mitología, uno de los cuatro elementos básicos.",
                        "Conjuntos de disparos de armas de fuego.",
                        "Entusiasmos o pasiones.",
                        "En ciertos juegos, conjuntos de cartas iguales."
                    )
                ),
                WordEntity(
                    "Estrellas",

                    arrayListOf(
                        "Cuerpos celestes luminosos en el cielo nocturno.",
                        "Personas destacadas y famosas.",
                        "En gastronomía, figuras de masa hojaldrada rellenas de crema o frutas.",
                        "Emblemas con puntas radiantes que simbolizan la divinidad.",
                        "En matemáticas, figuras con puntas que se forman al unir vértices de polígonos."
                    )
                ),
                WordEntity(
                    "Río",

                    arrayListOf(
                        "Corriente de agua continua y más o menos caudalosa que fluye hacia un mar, lago u otro río.",
                        "En geografía, término que indica flujo constante o sucesión continua.",
                        "En música, movimiento rápido y fluido de una composición.",
                        "En astronomía, término para describir líneas de estrellas en la Vía Láctea.",
                        "En poesía, metáfora de la corriente de la vida."
                    )
                ),
                WordEntity(
                    "Hormiga",

                    arrayListOf(
                        "Insecto social que vive en colonias.",
                        "Persona trabajadora y diligente.",
                        "En astronomía, sistema estelar triple.",
                        "En zoología, nombre de varios tipos de insectos.",
                        "En informática, tipo de software malicioso."
                    )
                ),
                WordEntity(
                    "Montañas",

                    arrayListOf(
                        "Elevaciones naturales y considerables del terreno.",
                        "En geografía, masas elevadas de tierra con cumbres y laderas pronunciadas.",
                        "En náutica, masas de agua elevadas y agitadas.",
                        "En música, intervalos ascendentes de tres tonos.",
                        "En gastronomía, postres elaborados en capas con diferentes ingredientes."
                    )
                ),
                WordEntity(
                    "Océano",

                    arrayListOf(
                        "Extensión muy amplia de agua salada que cubre la mayor parte de la superficie terrestre.",
                        "En geografía, masas de agua que se dividen en diferentes océanos.",
                        "En mitología, deidad relacionada con las aguas.",
                        "En poesía, símbolo de misterio y profundidad.",
                        "En biología, conjunto de organismos marinos interconectados."
                    )
                ),
                WordEntity(
                    "Bosques",

                    arrayListOf(
                        "Áreas extensas cubiertas de árboles, arbustos y vegetación.",
                        "En ecología, ecosistemas ricos en biodiversidad.",
                        "En geografía, regiones densamente arboladas.",
                        "En literatura, escenario mágico y misterioso.",
                        "En biología, hábitats cruciales para la salud del planeta."
                    )
                ),
                WordEntity(
                    "Sueños",

                    arrayListOf(
                        "Experiencias y pensamientos durante el sueño.",
                        "Ambiciones y metas en la vida.",
                        "En psicología, manifestaciones del inconsciente.",
                        "En literatura, vehículo de la imaginación.",
                        "En poesía, símbolo de esperanza y posibilidades."
                    )
                ),
                WordEntity(
                    "Aventura",

                    arrayListOf(
                        "Experiencia emocionante y arriesgada.",
                        "En literatura, género que narra hechos extraordinarios y emocionantes.",
                        "Viaje o recorrido con eventos inesperados.",
                        "En música, composición dinámica y emocionante.",
                        "Actitud de exploración y descubrimiento."
                    )
                ),
                WordEntity(
                    "Sombras",

                    arrayListOf(
                        "Imágenes oscuras proyectadas por la ausencia de luz.",
                        "En literatura, aspectos ocultos o desconocidos de la realidad.",
                        "Áreas no iluminadas en una pintura o fotografía.",
                        "En teatro, efectos visuales para crear dramatismo.",
                        "En psicología, aspectos no conscientes de la mente."
                    )
                ),
                WordEntity(
                    "Música",

                    arrayListOf(
                        "Arte de combinar sonidos de forma armónica y estética.",
                        "En filosofía, expresión emocional a través de sonidos.",
                        "Conjunto de sonidos organizados en una composición.",
                        "Disciplina que estudia la teoría musical.",
                        "En terapia, herramienta para el bienestar emocional."
                    )
                ),
                WordEntity(
                    "Desierto",

                    arrayListOf(
                        "Área extensa con escasa vegetación y poca precipitación.",
                        "En la vida, momentos de soledad y desolación.",
                        "En geografía, ecosistema adaptado a condiciones áridas.",
                        "En literatura, metáfora de lo inhóspito y deshabitado.",
                        "Campo de pruebas para exploración y supervivencia."
                    )
                ),
                WordEntity(
                    "Inviernos",

                    arrayListOf(
                        "Estación del año caracterizada por bajas temperaturas.",
                        "Épocas frías del año.",
                        "Períodos difíciles o desfavorables.",
                        "Momentos en que algo está en su apogeo o máxima intensidad.",
                        "En meteorología, fechas en las que comienza el invierno."
                    )
                ),
                WordEntity(
                    "Susurro",

                    arrayListOf(
                        "Sonido suave y apacible producido al hablar en voz baja.",
                        "En literatura, forma poética de expresión.",
                        "Indicación de secretos compartidos.",
                        "En naturaleza, sonido del viento entre las hojas.",
                        "En amor, expresión íntima de afecto."
                    )
                ),
                WordEntity(
                    "Ciudad",

                    arrayListOf(
                        "Área urbanizada con alta densidad de población.",
                        "Centro de actividad económica y cultural.",
                        "En literatura, escenario de encuentros y desafíos.",
                        "Entorno diverso con edificios y servicios.",
                        "En sociología, comunidad compleja e interconectada."
                    )
                ),
                WordEntity(
                    "Espejismo",

                    arrayListOf(
                        "Ilusión óptica que crea imágenes irreales.",
                        "En la vida, aspiraciones engañosas.",
                        "Fenómeno atmosférico que distorsiona la realidad.",
                        "En literatura, metáfora de deseos inalcanzables.",
                        "Engaño visual que desaparece al acercarse."
                    )
                ),
                WordEntity(
                    "Libro",

                    arrayListOf(
                        "Conjunto de hojas impresas o manuscritas unidas.",
                        "Obra literaria o científica de gran extensión.",
                        "En contabilidad, registro de transacciones.",
                        "Conjunto de cartas en un juego de naipes.",
                        "En música, parte de una partitura musical."
                    )
                ),
                WordEntity(
                    "Orquesta",

                    arrayListOf(
                        "Grupo musical compuesto por instrumentos variados.",
                        "En teatro, foso donde se ubican los músicos.",
                        "En organización, conjunto coordinado de personas.",
                        "En biología, grupo de proteínas que actúan juntas.",
                        "En tecnología, conjunto de componentes integrados."
                    )
                ),
                WordEntity(
                    "Aventureros",

                    arrayListOf(
                        "Personas que participan en experiencias emocionantes y arriesgadas.",
                        "Exploradores audaces y valientes.",
                        "En juegos de rol, personajes que buscan desafíos y tesoros.",
                        "Individuos que buscan nuevas oportunidades y descubrimientos.",
                        "En literatura, héroes de historias llenas de acción y riesgo."
                    )
                ),
                WordEntity(
                    "Sueños",

                    arrayListOf(
                        "Experiencias y pensamientos durante el sueño.",
                        "Ambiciones y metas en la vida.",
                        "En psicología, manifestaciones del inconsciente.",
                        "En literatura, vehículo de la imaginación.",
                        "En poesía, símbolo de esperanza y posibilidades."
                    )
                ),
                WordEntity(
                    "Mariposas",

                    arrayListOf(
                        "Insectos voladores con alas delicadas y coloridas.",
                        "Sensación de nervios o emoción en el estómago.",
                        "En botánica, planta con flores de forma similar a las alas de una mariposa.",
                        "Efecto visual en fotografía que se asemeja a la forma de una mariposa.",
                        "En música, técnica de vibrato en algunos instrumentos de cuerda."
                    )
                ),
                WordEntity(
                    "Silencio",

                    arrayListOf(
                        "Ausencia de sonido.",
                        "En literatura, pausa o espacio entre palabras.",
                        "Estado de tranquilidad y quietud.",
                        "En música, signo que indica ausencia de sonido.",
                        "En comunicación, falta de expresión verbal."
                    )
                ),
                WordEntity(
                    "Laberinto",

                    arrayListOf(
                        "Estructura con pasadizos y encrucijadas confusas.",
                        "Situación complicada y difícil de entender.",
                        "En mitología, construcción utilizada para encerrar al Minotauro.",
                        "En jardinería, diseño de caminos intrincados.",
                        "En psicología, metáfora de la mente humana."
                    )
                ),
                WordEntity(
                    "Burbujas",

                    arrayListOf(
                        "Pequeñas esferas de gas o líquido rodeadas de una delgada capa.",
                        "En economía, situación de sobrevaloración en los mercados.",
                        "Sensación efímera de felicidad o éxito.",
                        "En música, técnica vocal para crear sonidos burbujeantes.",
                        "En gastronomía, plato con burbujas de aire incorporadas."
                    )
                ),
                WordEntity(
                    "Misterio",

                    arrayListOf(
                        "Secreto o enigma que despierta curiosidad.",
                        "Cualidad de algo difícil de entender o explicar.",
                        "Género literario o cinematográfico que involucra lo desconocido.",
                        "En religión, realidad divina no completamente comprensible.",
                        "Acontecimiento o suceso no resuelto o explicado."
                    )
                ),
                WordEntity(
                    "Cascada",

                    arrayListOf(
                        "Caída de agua desde cierta altura.",
                        "En jardinería, estructura decorativa con agua que fluye.",
                        "En informática, flujo secuencial de información.",
                        "En moda, estilo de peinado con ondas descendentes.",
                        "En literatura, sucesión rápida y abundante de eventos."
                    )
                ),
                WordEntity(
                    "Sombras",

                    arrayListOf(
                        "Imágenes oscuras proyectadas por la ausencia de luz.",
                        "En literatura, aspectos ocultos o desconocidos de la realidad.",
                        "Áreas no iluminadas en una pintura o fotografía.",
                        "En teatro, efectos visuales para crear dramatismo.",
                        "En psicología, aspectos no conscientes de la mente."
                    )
                ),
                WordEntity(
                    "Viaje",

                    arrayListOf(
                        "Desplazamiento de un lugar a otro.",
                        "Experiencia que implica exploración y descubrimiento.",
                        "Trayecto o recorrido con propósito específico.",
                        "En literatura, metáfora de la vida como un viaje.",
                        "En música, progresión armónica que da sensación de movimiento."
                    )
                ),
                WordEntity(
                    "Tormenta",

                    arrayListOf(
                        "Fenómeno meteorológico con vientos fuertes, lluvia y truenos.",
                        "Situación intensa y conflictiva.",
                        "En astronomía, disturbio en la superficie solar.",
                        "En música, pieza con carácter tormentoso.",
                        "En poesía, metáfora de emociones intensas y turbulentas."
                    )
                ),
                WordEntity(
                    "Sinfonía",

                    arrayListOf(
                        "Composición musical para orquesta.",
                        "Armonía compleja y coordinada de elementos.",
                        "En literatura, estructura narrativa que combina diferentes hilos argumentales.",
                        "En tecnología, integración fluida de sistemas.",
                        "En filosofía, concepto de unidad y diversidad."
                    )
                ),
                WordEntity(
                    "Cristal",

                    arrayListOf(
                        "Sólido transparente con estructura ordenada de átomos.",
                        "En joyería, piedra preciosa tallada.",
                        "Material con alta claridad y brillo.",
                        "Elemento arquitectónico que permite la entrada de luz.",
                        "En informática, pantalla líquida para visualización de imágenes."
                    )
                ),
                WordEntity(
                    "Desierto",

                    arrayListOf(
                        "Área extensa con escasa vegetación y poca precipitación.",
                        "En la vida, momentos de soledad y desolación.",
                        "En geografía, ecosistema adaptado a condiciones áridas.",
                        "En literatura, metáfora de lo inhóspito y deshabitado.",
                        "Campo de pruebas para exploración y supervivencia."
                    )
                ),
                WordEntity(
                    "Aurora",

                    arrayListOf(
                        "Fenómeno luminoso en el cielo antes del amanecer.",
                        "En mitología, diosa del amanecer.",
                        "Inicio o surgimiento de algo.",
                        "En música, estilo de música electrónica.",
                        "En poesía, metáfora de esperanza y renovación."
                    )
                ),
                WordEntity(
                    "Laberinto",

                    arrayListOf(
                        "Estructura con pasadizos y encrucijadas confusas.",
                        "Situación complicada y difícil de entender.",
                        "En mitología, construcción utilizada para encerrar al Minotauro.",
                        "En jardinería, diseño de caminos intrincados.",
                        "En psicología, metáfora de la mente humana."
                    )
                ),
                WordEntity(
                    "Crepúsculo",

                    arrayListOf(
                        "Período del día antes del amanecer y después del atardecer.",
                        "En literatura, atmósfera melancólica y evocadora.",
                        "En astronomía, momento en que el sol está justo debajo del horizonte.",
                        "En pintura, técnica para representar la transición entre la luz y la oscuridad.",
                        "En poesía, metáfora de los momentos de transición en la vida."
                    )
                ),
                WordEntity(
                    "Espejismo",

                    arrayListOf(
                        "Ilusión óptica que crea imágenes irreales.",
                        "En la vida, aspiraciones engañosas.",
                        "Fenómeno atmosférico que distorsiona la realidad.",
                        "En literatura, metáfora de deseos inalcanzables.",
                        "Engaño visual que desaparece al acercarse."
                    )
                ),
                WordEntity(
                    "Tesoros",

                    arrayListOf(
                        "Bienes preciosos y valiosos.",
                        "Descubrimientos inesperados y apreciados.",
                        "En literatura, metáfora de las experiencias y conocimientos acumulados.",
                        "En mitología, objetos mágicos y valiosos.",
                        "Riquezas escondidas o por descubrir."
                    )
                ),
                WordEntity(
                    "Travesía",

                    arrayListOf(
                        "Viaje largo y difícil.",
                        "Aventura que implica superar obstáculos.",
                        "Recorrido por tierra, mar o aire.",
                        "En literatura, paso crucial en la trama.",
                        "En poesía, metáfora de la travesía de la vida."
                    )
                ),
                WordEntity(
                    "Ecos",

                    arrayListOf(
                        "Reflejos del sonido producido por la reflexión de las ondas acústicas.",
                        "Repetición o resonancia de algo.",
                        "En literatura, influencias o reverberaciones de obras anteriores.",
                        "En política, repetición de discursos o ideologías.",
                        "En naturaleza, sonidos que persisten después de la fuente original."
                    )
                ),
                WordEntity(
                    "Fantasía",

                    arrayListOf(
                        "Capacidad de imaginar cosas que no existen.",
                        "Género literario o artístico que involucra elementos imaginativos.",
                        "En música, composición libre y caprichosa.",
                        "En psicología, actividad mental creativa.",
                        "Elemento decorativo sin función práctica."
                    )
                ),
                WordEntity(
                    "Máscaras",

                    arrayListOf(
                        "Objetos que cubren el rostro para ocultar la identidad.",
                        "En teatro, elementos que representan personajes o emociones.",
                        "En informática, patrones de bits utilizados para filtrar datos.",
                        "En biología, estructuras que ocultan la verdadera naturaleza de algo.",
                        "En moda, accesorios decorativos para el rostro."
                    )
                ),
                WordEntity(
                    "Inviernos",

                    arrayListOf(
                        "Estación del año caracterizada por bajas temperaturas.",
                        "Épocas frías del año.",
                        "Períodos difíciles o desfavorables.",
                        "Momentos en que algo está en su apogeo o máxima intensidad.",
                        "En meteorología, fechas en las que comienza el invierno."
                    )
                ),
                WordEntity(
                    "Candiles",

                    arrayListOf(
                        "Lámparas con depósito para aceite o grasa.",
                        "Elementos decorativos que emiten luz.",
                        "En arquitectura, ornamentación en forma de lámpara.",
                        "En meteorología, fenómeno luminoso en nubes estratosféricas.",
                        "Dispositivos que iluminan y guían en la oscuridad."
                    )
                ), WordEntity(
                    "Renacimiento",

                    arrayListOf(
                        "Época de renovación cultural en Europa.",
                        "En la vida, resurgimiento y rejuvenecimiento.",
                        "En arte, movimiento que valoriza la belleza clásica.",
                        "En filosofía, renacer de la razón y el humanismo.",
                        "Renovación y redescubrimiento de conocimientos."
                    )
                ),
                WordEntity(
                    "Aurora",

                    arrayListOf(
                        "Fenómeno luminoso antes del amanecer.",
                        "En mitología, diosa del amanecer.",
                        "En la vida, comienzo de algo nuevo y prometedor.",
                        "En literatura, símbolo de esperanza y renovación.",
                        "Colores y luces en el cielo al despuntar el día."
                    )
                ),
                WordEntity(
                    "Despertar",

                    arrayListOf(
                        "Acción de recobrar la conciencia después del sueño.",
                        "En la vida, toma de conciencia o comprensión.",
                        "En literatura, símbolo de iluminación y conocimiento.",
                        "Inicio de una nueva fase o etapa.",
                        "Revivir y cobrar vida después de un período."
                    )
                ),
                WordEntity(
                    "Tranquilidad",

                    arrayListOf(
                        "Estado de paz y calma.",
                        "En la vida, ausencia de disturbios y preocupaciones.",
                        "En la naturaleza, ambiente sereno y apacible.",
                        "Sensación de armonía y relajación.",
                        "Pausa tranquila en medio de la actividad."
                    )
                ),
                WordEntity(
                    "Vértigo",

                    arrayListOf(
                        "Sensación de mareo y desequilibrio.",
                        "En la vida, vértigo emocional o existencial.",
                        "En arquitectura, elemento visual que causa ilusión de altura.",
                        "En literatura, símbolo de la incertidumbre y la inestabilidad.",
                        "Rápido giro o movimiento circular."
                    )
                ),
                WordEntity(
                    "Ecos",

                    arrayListOf(
                        "Reflejo del sonido en una superficie.",
                        "Repetición o resonancia de algo dicho o hecho.",
                        "En la vida, consecuencias o repercusiones de acciones.",
                        "En literatura, repetición simbólica de eventos.",
                        "Conexiones y repeticiones en la naturaleza."
                    )
                ),
                WordEntity(
                    "Desafío",

                    arrayListOf(
                        "Reto o dificultad a superar.",
                        "En la vida, oportunidad para demostrar habilidades.",
                        "En competiciones, prueba que pone a prueba capacidades.",
                        "En literatura, conflicto que impulsa la trama.",
                        "Superación personal ante situaciones difíciles."
                    )
                ),
                WordEntity(
                    "Palimpsesto",

                    arrayListOf(
                        "Manuscrito antiguo con escrituras superpuestas.",
                        "En la vida, capas de experiencias y memorias.",
                        "En arquitectura, estructura con capas de remodelación.",
                        "En literatura, metáfora de la historia y la memoria.",
                        "Superposición de significados en una obra artística."
                    )
                ),
                WordEntity(
                    "Éxtasis",

                    arrayListOf(
                        "Estado de éxtasis o trance.",
                        "En la vida, momento de felicidad intensa.",
                        "En la religión, experiencia mística.",
                        "En la literatura, clímax emocional.",
                        "Elevación espiritual o emocional intensa."
                    )
                ),
                WordEntity(
                    "Maraña",

                    arrayListOf(
                        "Conjunto enredado y confuso de cosas.",
                        "En la vida, situaciones complicadas y caóticas.",
                        "En la naturaleza, red de plantas o hilos entrelazados.",
                        "En literatura, metáfora de la complejidad.",
                        "En la mente, pensamientos enredados y difíciles de resolver."
                    )
                ),
                WordEntity(
                    "Azar",

                    arrayListOf(
                        "Causalidad fortuita o sin planificación.",
                        "En la vida, elementos imprevisibles y aleatorios.",
                        "En juegos, factor de suerte.",
                        "En literatura, eventos sin premeditación.",
                        "En filosofía, concepto de falta de determinismo."
                    )
                ),
                WordEntity(
                    "Retorno",

                    arrayListOf(
                        "Acción de volver o regresar.",
                        "En la vida, volver a situaciones anteriores.",
                        "En la literatura, arco narrativo de regreso.",
                        "En la naturaleza, ciclo de renovación.",
                        "Reaparición o recuperación de algo perdido."
                    )
                ),
                WordEntity(
                    "Rincón",

                    arrayListOf(
                        "Área pequeña y apartada.",
                        "En la vida, lugar acogedor y tranquilo.",
                        "En la naturaleza, escondite para animales.",
                        "En literatura, escenario íntimo de eventos.",
                        "Espacio especial y personal en el hogar."
                    )
                ),
                WordEntity(
                    "Despedida",

                    arrayListOf(
                        "Acción de decir adiós.",
                        "En la vida, separación o término de una etapa.",
                        "En literatura, momento emotivo de despedida.",
                        "En relaciones, cierre de una conexión.",
                        "Símbolo de cambio y nuevos comienzos."
                    )
                ),
                WordEntity(
                    "Nébula",

                    arrayListOf(
                        "Nube de gas y polvo interestelar.",
                        "En astronomía, región de formación estelar.",
                        "En la vida, neblina o confusión.",
                        "En la literatura, metáfora de la creatividad.",
                        "Conjunto de partículas suspendidas en el espacio."
                    )
                ),
                WordEntity(
                    "Confín",

                    arrayListOf(
                        "Límite o borde de algo.",
                        "En la vida, punto final o frontera.",
                        "En la naturaleza, horizonte lejano.",
                        "En literatura, metáfora de lo desconocido.",
                        "Punto donde convergen múltiples posibilidades."
                    )
                ),
                WordEntity(
                    "Crepúsculo",

                    arrayListOf(
                        "Periodo de transición entre el día y la noche.",
                        "En la vida, momentos de cambio y reflexión.",
                        "En la naturaleza, juego de colores en el cielo.",
                        "En literatura, metáfora de la ambigüedad.",
                        "Sensación de misterio y transitoriedad."
                    )
                ),
                WordEntity(
                    "Eclipse",

                    arrayListOf(
                        "Ocultación temporal de un astro por otro.",
                        "En la vida, momentos de oscuridad y ocultamiento.",
                        "En la literatura, metáfora de la pérdida o el cambio.",
                        "En astronomía, fenómeno celestial.",
                        "En la naturaleza, juego de sombras y luces."
                    )
                ),
                WordEntity(
                    "Galaxia",

                    arrayListOf(
                        "Enorme sistema estelar que incluye estrellas, planetas y materia interestelar.",
                        "En la vida, conjunto complejo y vasto de experiencias.",
                        "En astronomía, agrupación de estrellas y sistemas solares.",
                        "En literatura, metáfora de la diversidad y complejidad.",
                        "Estructura cósmica que forma el tejido del universo."
                    )
                ),
                WordEntity(
                    "Pausa",

                    arrayListOf(
                        "Interrupción temporal o descanso.",
                        "En la vida, momento de reflexión y detenimiento.",
                        "En la música, indicación de detenerse por un instante.",
                        "En la literatura, metáfora de la tranquilidad.",
                        "Espacio entre eventos o sonidos."
                    )
                ),
                WordEntity(
                    "Límite",

                    arrayListOf(
                        "Punto final o extremo de algo.",
                        "En la vida, frontera o restricción.",
                        "En matemáticas, valor al cual se acercan sucesiones.",
                        "En la naturaleza, punto de contacto entre dos entidades.",
                        "Restricción que impone condiciones."
                    )
                ),
                WordEntity(
                    "Estirpe",

                    arrayListOf(
                        "Línea de descendencia.",
                        "En la vida, herencia y linaje.",
                        "En la literatura, metáfora de la tradición y la conexión familiar.",
                        "En biología, grupo de organismos con características comunes.",
                        "Raíz ancestral que conecta generaciones."
                    )
                ),
                WordEntity(
                    "Ecosistema",

                    arrayListOf(
                        "Conjunto de seres vivos y su entorno físico.",
                        "En biología, sistema interconectado de organismos.",
                        "En ecología, equilibrio entre especies y su hábitat.",
                        "En informática, sistema complejo y autosuficiente.",
                        "Interacciones y dependencias en una comunidad."
                    )
                ),
                WordEntity(
                    "Reverie",

                    arrayListOf(
                        "Estado de ensueño o distracción.",
                        "En la vida, momentos de imaginación y evasión.",
                        "En música, composición lírica y soñadora.",
                        "En la literatura, metáfora de la contemplación.",
                        "Sueños y fantasías placenteras."
                    )
                ),
                WordEntity(
                    "Refugio",

                    arrayListOf(
                        "Lugar de protección y resguardo.",
                        "En la vida, espacio seguro y reconfortante.",
                        "En la naturaleza, lugar de refugio para animales.",
                        "En la literatura, metáfora de apoyo y consuelo.",
                        "Santuario o abrigo contra peligros."
                    )
                ),
                WordEntity(
                    "Deslumbramiento",

                    arrayListOf(
                        "Asombro causado por una luz intensa.",
                        "En la vida, admiración y fascinación intensa.",
                        "En la naturaleza, efecto luminoso deslumbrante.",
                        "En la literatura, metáfora de la maravilla.",
                        "Sensación de deslumbrar o ser deslumbrado."
                    )
                ),
                WordEntity(
                    "Quimera",

                    arrayListOf(
                        "Criatura mitológica con cuerpo de león, cabeza de cabra y cola de serpiente.",
                        "En la vida, ilusión o fantasía inalcanzable.",
                        "En literatura, creación imaginaria e irreal.",
                        "En biología, organismo con características improbables.",
                        "Proyecto o sueño utópico."
                    )
                ),
                WordEntity(
                    "Transcendencia",

                    arrayListOf(
                        "Superación de los límites ordinarios.",
                        "En la vida, alcanzar niveles más allá de lo común.",
                        "En filosofía, ir más allá de lo fenoménico.",
                        "En la literatura, metáfora de la importancia duradera.",
                        "Elevarse por encima de las limitaciones."
                    )
                ),
                WordEntity(
                    "Resiliencia",

                    arrayListOf(
                        "Capacidad de adaptarse y recuperarse de la adversidad.",
                        "En la vida, resistencia y flexibilidad frente a desafíos.",
                        "En psicología, capacidad de superar traumas.",
                        "En la naturaleza, capacidad de resistir condiciones adversas.",
                        "Fortaleza emocional y capacidad de recuperación."
                    )
                ),
                WordEntity(
                    "Encrucijada",

                    arrayListOf(
                        "Punto de convergencia o decisión.",
                        "En la vida, momento crucial de elección.",
                        "En la literatura, conflicto fundamental.",
                        "En la naturaleza, intersección de caminos.",
                        "Situación decisiva que altera el curso."
                    )
                ),
                WordEntity(
                    "Zafarrancho",

                    arrayListOf(
                        "Desorden o confusión.",
                        "En la vida, situación caótica e incontrolada.",
                        "En la marina, preparativos antes de la acción.",
                        "Acción rápida y enérgica.",
                        "Reorganización y limpieza apresurada."
                    )
                ),
                WordEntity(
                    "Zozobra",

                    arrayListOf(
                        "Intranquilidad y angustia.",
                        "En la vida, sensación de ansiedad.",
                        "En la navegación, movimiento inestable.",
                        "Inquietud y desasosiego.",
                        "Situación de perturbación emocional."
                    )
                ),
                WordEntity(
                    "Zaguán",

                    arrayListOf(
                        "Entrada o vestíbulo de una casa.",
                        "En arquitectura, espacio cubierto antes de la puerta principal.",
                        "En la vida, área de transición y bienvenida.",
                        "Zona de recepción y acceso.",
                        "Puerta de entrada a un edificio."
                    )
                ),
                WordEntity(
                    "Zócalo",

                    arrayListOf(
                        "Base o parte inferior de un objeto.",
                        "En arquitectura, parte inferior de una pared.",
                        "En la vida, elemento de soporte y fundamento.",
                        "En decoración, moldura que adorna la parte inferior de una pared.",
                        "En informática, interfaz gráfica de usuario."
                    )
                ),
                WordEntity(
                    "Zóster",

                    arrayListOf(
                        "Enfermedad viral que afecta los nervios.",
                        "En medicina, erupción cutánea y dolor nervioso.",
                        "En la vida, condición de salud dolorosa.",
                        "Infección provocada por el virus de la varicela.",
                        "Complicación del virus de la varicela."
                    )
                ),
                WordEntity(
                    "Zafio",

                    arrayListOf(
                        "Que carece de educación o refinamiento.",
                        "En la vida, comportamiento grosero y vulgar.",
                        "En la sociedad, falta de modales y cortesía.",
                        "Persona tosca y sin delicadeza.",
                        "Falta de sensibilidad social."
                    )
                ),
                WordEntity(
                    "Zalamero",

                    arrayListOf(
                        "Que halaga excesivamente.",
                        "En la vida, persona aduladora y servil.",
                        "En relaciones, actitud exageradamente elogiosa.",
                        "Expresión excesiva de afecto para obtener favores.",
                        "Halago insincero y exagerado."
                    )
                ),
                WordEntity(
                    "Zafio",

                    arrayListOf(
                        "Que carece de educación o refinamiento.",
                        "En la vida, comportamiento grosero y vulgar.",
                        "En la sociedad, falta de modales y cortesía.",
                        "Persona tosca y sin delicadeza.",
                        "Falta de sensibilidad social."
                    )
                ),
                WordEntity(
                    "Zaguán",

                    arrayListOf(
                        "Entrada o vestíbulo de una casa.",
                        "En arquitectura, espacio cubierto antes de la puerta principal.",
                        "En la vida, área de transición y bienvenida.",
                        "Zona de recepción y acceso.",
                        "Puerta de entrada a un edificio."
                    )
                ),
                WordEntity(
                    "Zodiaco",

                    arrayListOf(
                        "Cinturón imaginario de la esfera celeste.",
                        "En astrología, división en doce signos.",
                        "En la vida, símbolo de personalidad según el nacimiento.",
                        "Ciclo anual de constelaciones.",
                        "Influencia astrológica en creencias populares."
                    )
                ),
                WordEntity(
                    "Coyote",

                    arrayListOf(
                        "Mamífero carnívoro de la familia de los cánidos.",
                        "En la vida, símbolo de astucia y adaptabilidad.",
                        "En la naturaleza, depredador nocturno.",
                        "Animal salvaje con hábitos solitarios.",
                        "Representación simbólica en mitologías indígenas."
                    )
                ),
                WordEntity(
                    "Yoga",

                    arrayListOf(
                        "Disciplina física, mental y espiritual.",
                        "En la vida, práctica para el bienestar.",
                        "En la filosofía hindú, unión del cuerpo y la mente.",
                        "Sistema de ejercicios y meditación.",
                        "Camino hacia la autorrealización."
                    )
                ),
                WordEntity(
                    "Rayo",

                    arrayListOf(
                        "Descarga eléctrica producida por la atmósfera.",
                        "En la vida, fenómeno natural impresionante.",
                        "En la mitología, arma divina asociada con deidades.",
                        "Rápido destello de luz.",
                        "En la naturaleza, manifestación poderosa de energía."
                    )
                ),
                WordEntity(
                    "Cuy",

                    arrayListOf(
                        "Roedor de la familia de los caviomorfos.",
                        "En la vida, animal de compañía en algunas culturas.",
                        "Consumido como alimento en ciertas regiones.",
                        "Pequeño mamífero originario de los Andes.",
                        "Conocido por su pelaje suave y comportamiento dócil."
                    )
                ),
                WordEntity(
                    "Yoga",

                    arrayListOf(
                        "Disciplina física, mental y espiritual.",
                        "En la vida, práctica para el bienestar.",
                        "En la filosofía hindú, unión del cuerpo y la mente.",
                        "Sistema de ejercicios y meditación.",
                        "Camino hacia la autorrealización."
                    )
                ),
                WordEntity(
                    "Yacimiento",

                    arrayListOf(
                        "Lugar donde se encuentran depósitos de minerales o fósiles.",
                        "En la arqueología, sitio de restos históricos.",
                        "En la vida, fuente de recursos naturales.",
                        "Área de interés científico y arqueológico.",
                        "Zona con evidencia de actividad humana pasada."
                    )
                ),
                WordEntity(
                    "Yodo",

                    arrayListOf(
                        "Elemento químico con símbolo I.",
                        "En la vida, esencial para la función tiroidea.",
                        "En la medicina, utilizado como desinfectante.",
                        "Presente en ciertos alimentos y agua de mar.",
                        "Contribuye al buen funcionamiento del cuerpo humano."
                    )
                ),
                WordEntity(
                    "Yunque",

                    arrayListOf(
                        "Instrumento de metal con superficie plana y yunque.",
                        "En la vida, herramienta utilizada en la herrería.",
                        "En la naturaleza, formación rocosa similar a un yunque.",
                        "En la anatomía, parte del oído interno.",
                        "Símbolo de la fragua y la forja."
                    )
                ),
                WordEntity(
                    "Búho",

                    arrayListOf(
                        "Ave rapaz nocturna de la familia de los estrígidos.",
                        "En la vida, símbolo de sabiduría en algunas culturas.",
                        "En la mitología, asociado con deidades de la noche.",
                        "Conocido por su vuelo silencioso.",
                        "Cazador eficiente de roedores y pequeños mamíferos."
                    )
                ),
                WordEntity(
                    "Coyote",

                    arrayListOf(
                        "Mamífero carnívoro de la familia de los cánidos.",
                        "En la vida, símbolo de astucia y adaptabilidad.",
                        "En la naturaleza, depredador nocturno.",
                        "Animal salvaje con hábitos solitarios.",
                        "Representación simbólica en mitologías indígenas."
                    )
                ),
                WordEntity(
                    "Aventura",

                    arrayListOf(
                        "Viaje emocionante y arriesgado.",
                        "En la vida, experiencia llena de desafíos y descubrimientos.",
                        "En la literatura, género narrativo de hazañas y peripecias.",
                        "Búsqueda de lo desconocido y lo extraordinario.",
                        "Situación que involucra riesgo y emoción."
                    )
                ),
                WordEntity(
                    "Arcoiris",

                    arrayListOf(
                        "Fenómeno óptico y meteorológico.",
                        "En la vida, símbolo de diversidad y esperanza.",
                        "En la mitología, puente entre la tierra y el cielo.",
                        "Colores que aparecen en el cielo después de la lluvia.",
                        "Arco de luz coloreada por la refracción."
                    )
                ),
                WordEntity(
                    "Amarillo",

                    arrayListOf(
                        "Color primario entre el verde y el naranja.",
                        "En la vida, asociado con la luz del sol y la energía.",
                        "En la naturaleza, color de flores y frutas.",
                        "Símbolo de alegría, optimismo y creatividad.",
                        "Tono cálido que evoca sensaciones vibrantes."
                    )
                ),
                WordEntity(
                    "Aventura",

                    arrayListOf(
                        "Viaje emocionante y arriesgado.",
                        "En la vida, experiencia llena de desafíos y descubrimientos.",
                        "En la literatura, género narrativo de hazañas y peripecias.",
                        "Búsqueda de lo desconocido y lo extraordinario.",
                        "Situación que involucra riesgo y emoción."
                    )
                ),
                WordEntity(
                    "Anochecer",

                    arrayListOf(
                        "Periodo del día justo después del atardecer.",
                        "En la vida, transición hacia la noche.",
                        "En la naturaleza, juego de colores en el cielo.",
                        "Momento de calma y reflexión.",
                        "Ambiente tranquilo al final del día."
                    )
                ),
                WordEntity(
                    "Aroma",

                    arrayListOf(
                        "Olor agradable y distintivo.",
                        "En la vida, sensación asociada con fragancias.",
                        "En la naturaleza, emanación de plantas y flores.",
                        "Símbolo de recuerdos y emociones.",
                        "Elemento esencial en la experiencia gustativa."
                    )
                ),
                WordEntity(
                    "Aventura",

                    arrayListOf(
                        "Viaje emocionante y arriesgado.",
                        "En la vida, experiencia llena de desafíos y descubrimientos.",
                        "En la literatura, género narrativo de hazañas y peripecias.",
                        "Búsqueda de lo desconocido y lo extraordinario.",
                        "Situación que involucra riesgo y emoción."
                    )
                ),
                WordEntity(
                    "Alquimia",

                    arrayListOf(
                        "Antigua práctica mística y filosófica.",
                        "En la vida, transformación de lo ordinario en extraordinario.",
                        "En la historia, búsqueda de la piedra filosofal.",
                        "Metáfora de cambio profundo y espiritual.",
                        "Simboliza la transmutación de la materia y el espíritu."
                    )
                ),
                WordEntity(
                    "Aurora",

                    arrayListOf(
                        "Fenómeno luminoso antes del amanecer.",
                        "En mitología, diosa del amanecer.",
                        "En la vida, comienzo de algo nuevo y prometedor.",
                        "En literatura, símbolo de esperanza y renovación.",
                        "Colores y luces en el cielo al despuntar el día."
                    )
                ),
                WordEntity(
                    "Alba",

                    arrayListOf(
                        "Primeras horas del día, justo antes del amanecer.",
                        "En la vida, símbolo de un nuevo comienzo.",
                        "En la naturaleza, luz suave antes del amanecer.",
                        "Momento de calma y serenidad.",
                        "Inicio de la jornada con luz tenue."
                    )
                ),
                WordEntity(
                    "Bosque",

                    arrayListOf(
                        "Extensa área cubierta de árboles y vegetación.",
                        "En la vida, ecosistema vital para la Tierra.",
                        "En la naturaleza, hábitat de diversas especies.",
                        "Lugar de tranquilidad y conexión con la naturaleza.",
                        "Área que contribuye a la salud del medio ambiente."
                    )
                ),
                WordEntity(
                    "Brisa",

                    arrayListOf(
                        "Viento suave y agradable.",
                        "En la vida, sensación refrescante.",
                        "En la naturaleza, movimiento del aire.",
                        "Elemento que lleva aromas y sonidos.",
                        "Beso suave del viento en la piel."
                    )
                ),
                WordEntity(
                    "Buceo",

                    arrayListOf(
                        "Actividad subacuática de exploración.",
                        "En la vida, experiencia de inmersión en el agua.",
                        "En el deporte, técnica de nadar bajo el agua.",
                        "Exploración de vida marina.",
                        "Aventura acuática con equipos especializados."
                    )
                ),
                WordEntity(
                    "Biblioteca",

                    arrayListOf(
                        "Lugar que alberga una colección de libros.",
                        "En la vida, espacio de conocimiento y aprendizaje.",
                        "En la educación, recurso fundamental.",
                        "Ambiente de silencio y estudio.",
                        "Guardiana del saber y la cultura."
                    )
                ),
                WordEntity(
                    "Beso",

                    arrayListOf(
                        "Contacto de labios expresando afecto.",
                        "En la vida, gesto íntimo y emocional.",
                        "En el amor, símbolo de cariño y conexión.",
                        "Forma de comunicación no verbal.",
                        "Expresión universal de afecto."
                    )
                ),
                WordEntity(
                    "Balneario",

                    arrayListOf(
                        "Lugar de recreo con aguas termales o marinas.",
                        "En la vida, destino para descanso y relajación.",
                        "En la salud, beneficios terapéuticos del agua.",
                        "Centro turístico con instalaciones acuáticas.",
                        "Espacio para cuidado del bienestar y la salud."
                    )
                ),
                WordEntity(
                    "Bosque",

                    arrayListOf(
                        "Extensa área cubierta de árboles y vegetación.",
                        "En la vida, ecosistema vital para la Tierra.",
                        "En la naturaleza, hábitat de diversas especies.",
                        "Lugar de tranquilidad y conexión con la naturaleza.",
                        "Área que contribuye a la salud del medio ambiente."
                    )
                ),
                WordEntity(
                    "Benevolencia",

                    arrayListOf(
                        "Actitud amable y generosa.",
                        "En la vida, disposición para hacer el bien.",
                        "En las relaciones, muestra de compasión y bondad.",
                        "Cualidad de ser benévolo y comprensivo.",
                        "Práctica de actos caritativos y altruistas."
                    )
                ),
                WordEntity(
                    "Bálsamo",

                    arrayListOf(
                        "Sustancia curativa o calmante.",
                        "En la vida, remedio para aliviar sufrimientos.",
                        "En la naturaleza, resina con propiedades medicinales.",
                        "Alivio para el cuerpo y el espíritu.",
                        "Elemento que reconforta y suaviza."
                    )
                ),
                WordEntity(
                    "Brisa",

                    arrayListOf(
                        "Viento suave y agradable.",
                        "En la vida, sensación refrescante.",
                        "En la naturaleza, movimiento del aire.",
                        "Elemento que lleva aromas y sonidos.",
                        "Beso suave del viento en la piel."
                    )
                ),
                WordEntity(
                    "Cascada",

                    arrayListOf(
                        "Caída de agua natural.",
                        "En la naturaleza, fenómeno escénico impresionante.",
                        "En la vida, símbolo de fluidez y renovación.",
                        "Atractivo turístico en entornos naturales.",
                        "Sonido relajante de agua en movimiento."
                    )
                ),
                WordEntity(
                    "Cálido",

                    arrayListOf(
                        "Temperatura agradablemente alta.",
                        "En la vida, sensación de calor reconfortante.",
                        "En los colores, tono que evoca calidez.",
                        "Ambiente acogedor y placentero.",
                        "Contrario de frío en términos térmicos."
                    )
                ),
                WordEntity(
                    "Canción",

                    arrayListOf(
                        "Composición musical con letra.",
                        "En la vida, expresión artística y emocional.",
                        "En la cultura, forma de transmitir historias y sentimientos.",
                        "Melodía que evoca emociones.",
                        "Elemento fundamental en la música."
                    )
                ),
                WordEntity(
                    "Candor",

                    arrayListOf(
                        "Honestidad y franqueza.",
                        "En la vida, transparencia en palabras y acciones.",
                        "En las relaciones, sinceridad y confianza.",
                        "Claridad y pureza en el discurso.",
                        "Ausencia de engaño y ocultamiento."
                    )
                ),
                WordEntity(
                    "Café",

                    arrayListOf(
                        "Bebida aromática preparada con granos de café.",
                        "En la vida, estimulante popular.",
                        "En la cultura, momento de encuentro y conversación.",
                        "Variedad de tonos en colores y sabores.",
                        "Ritual matutino o social."
                    )
                ),
                WordEntity(
                    "Cascada",

                    arrayListOf(
                        "Caída de agua natural.",
                        "En la naturaleza, fenómeno escénico impresionante.",
                        "En la vida, símbolo de fluidez y renovación.",
                        "Atractivo turístico en entornos naturales.",
                        "Sonido relajante de agua en movimiento."
                    )
                ),
                WordEntity(
                    "Candela",

                    arrayListOf(
                        "Flama o llama de fuego.",
                        "En la vida, fuente de luz y calor.",
                        "En celebraciones, símbolo de celebración y luminosidad.",
                        "Elemento que consume materia y transforma.",
                        "Unidad de medida de intensidad luminosa."
                    )
                ),
                WordEntity(
                    "Crisálida",

                    arrayListOf(
                        "Etapa de desarrollo de ciertos insectos.",
                        "En la vida, metamorfosis y transformación.",
                        "Símbolo de cambio y evolución.",
                        "Proceso de crecimiento y renovación.",
                        "Estado previo a la transformación completa."
                    )
                ),
                WordEntity(
                    "Cálido",

                    arrayListOf(
                        "Temperatura agradablemente alta.",
                        "En la vida, sensación de calor reconfortante.",
                        "En los colores, tono que evoca calidez.",
                        "Ambiente acogedor y placentero.",
                        "Contrario de frío en términos térmicos."
                    )
                ),
                WordEntity(
                    "Delfín",

                    arrayListOf(
                        "Mamífero marino inteligente.",
                        "En la vida, símbolo de gracia y juego.",
                        "En la naturaleza, nadador ágil y curioso.",
                        "Animal asociado con la diversión y la libertad.",
                        "Parte de la fauna marina fascinante."
                    )
                ),
                WordEntity(
                    "Danza",

                    arrayListOf(
                        "Expresión artística a través del movimiento.",
                        "En la vida, forma de comunicación no verbal.",
                        "En la cultura, manifestación de la identidad.",
                        "Ritual social y celebración.",
                        "Conjunto de movimientos rítmicos y expresivos."
                    )
                ),
                WordEntity(
                    "Deslumbrante",

                    arrayListOf(
                        "Que causa admiración y asombro.",
                        "En la vida, impresionante y brillante.",
                        "En la apariencia, radiante y espectacular.",
                        "Atractivo visual que deslumbra.",
                        "Que capta la atención de manera impactante."
                    )
                ),
                WordEntity(
                    "Diversidad",

                    arrayListOf(
                        "Variedad y diferencia entre elementos.",
                        "En la vida, riqueza de culturas y perspectivas.",
                        "En la sociedad, respeto a la pluralidad.",
                        "Valoración de la heterogeneidad.",
                        "Reconocimiento y aprecio por la variedad."
                    )
                ),
                WordEntity(
                    "Dulce",

                    arrayListOf(
                        "Sabor caracterizado por suavidad y azúcar.",
                        "En la vida, agrado y placer sensorial.",
                        "En la gastronomía, categoría de alimentos.",
                        "Expresión de cariño y ternura.",
                        "Contraparte de lo salado en el gusto."
                    )
                ),
                WordEntity(
                    "Deseo",

                    arrayListOf(
                        "Anhelo o ansiar algo.",
                        "En la vida, motivación y aspiración.",
                        "En las relaciones, atracción emocional.",
                        "Impulso hacia la consecución de metas.",
                        "Elemento vital para la realización personal."
                    )
                ),
                WordEntity(
                    "Destino",

                    arrayListOf(
                        "Rumbo o dirección hacia el cual se avanza.",
                        "En la vida, trayectoria vital.",
                        "En la filosofía, concepto de predeterminación.",
                        "Lugar o situación final.",
                        "Fuerza que guía eventos inevitables."
                    )
                ),
                WordEntity(
                    "Delfín",

                    arrayListOf(
                        "Mamífero marino inteligente.",
                        "En la vida, símbolo de gracia y juego.",
                        "En la naturaleza, nadador ágil y curioso.",
                        "Animal asociado con la diversión y la libertad.",
                        "Parte de la fauna marina fascinante."
                    )
                ),
                WordEntity(
                    "Delicia",

                    arrayListOf(
                        "Placer intenso y agradable.",
                        "En la vida, experiencia sensorial gratificante.",
                        "En la gastronomía, manjar delicioso.",
                        "Momento o situación que causa satisfacción.",
                        "Sensación de disfrute y contentamiento."
                    )
                ),
                WordEntity(
                    "Deslumbrante",

                    arrayListOf(
                        "Que causa admiración y asombro.",
                        "En la vida, impresionante y brillante.",
                        "En la apariencia, radiante y espectacular.",
                        "Atractivo visual que deslumbra.",
                        "Que capta la atención de manera impactante."
                    )
                ),
                WordEntity(
                    "Esplendor",

                    arrayListOf(
                        "Brillo intenso y radiante.",
                        "En la vida, estado de grandeza y magnificencia.",
                        "En la naturaleza, resplandor luminoso.",
                        "Sensación de grandiosidad y belleza.",
                        "Momento de esplendor y esplendidez."
                    )
                ),
                WordEntity(
                    "Encanto",

                    arrayListOf(
                        "Atractivo que cautiva y seduce.",
                        "En la vida, carisma y magia.",
                        "En las relaciones, cualidad irresistible.",
                        "Sensación de deleite y fascinación.",
                        "Elemento que provoca admiración y enamoramiento."
                    )
                ),
                WordEntity(
                    "Ecosistema",

                    arrayListOf(
                        "Sistema natural de interacción entre seres vivos y su entorno.",
                        "En la vida, equilibrio ambiental.",
                        "En la ecología, red de relaciones biológicas.",
                        "Conjunto de comunidades bióticas.",
                        "Interdependencia entre flora y fauna en un área específica."
                    )
                ),
                WordEntity(
                    "Eclipse",

                    arrayListOf(
                        "Fenómeno astronómico de oscurecimiento temporal de un astro.",
                        "En la vida, momento de transformación y cambio.",
                        "En la naturaleza, alineación celestial impresionante.",
                        "Símbolo de transición y renovación.",
                        "Evento cósmico de gran impacto visual."
                    )
                ),
                WordEntity(
                    "Esfuerzo",

                    arrayListOf(
                        "Acción de aplicar fuerza o energía para lograr un objetivo.",
                        "En la vida, dedicación y perseverancia.",
                        "En los logros, trabajo arduo y constante.",
                        "Contribución activa para alcanzar metas.",
                        "Elemento esencial para el progreso y el éxito."
                    )
                ),
                WordEntity(
                    "Euforia",

                    arrayListOf(
                        "Sensación de felicidad y exaltación.",
                        "En la vida, estado de gran alegría y bienestar.",
                        "En las emociones, experiencia de éxtasis.",
                        "Sentimiento de plenitud y satisfacción.",
                        "Elevación del ánimo a niveles máximos."
                    )
                ),
                WordEntity(
                    "Esplendor",

                    arrayListOf(
                        "Brillo intenso y radiante.",
                        "En la vida, estado de grandeza y magnificencia.",
                        "En la naturaleza, resplandor luminoso.",
                        "Sensación de grandiosidad y belleza.",
                        "Momento de esplendor y esplendidez."
                    )
                ),
                WordEntity(
                    "Enigma",

                    arrayListOf(
                        "Misterio o situación difícil de entender.",
                        "En la vida, incógnita fascinante.",
                        "En el arte, elemento enigmático y desconcertante.",
                        "Rompecabezas intelectual.",
                        "Pregunta sin respuesta clara."
                    )
                ),
                WordEntity(
                    "Empatía",

                    arrayListOf(
                        "Capacidad de entender y compartir los sentimientos de otros.",
                        "En las relaciones, habilidad de conectarse emocionalmente.",
                        "En la vida, comprensión profunda de las emociones ajenas.",
                        "Fundamento de la empatía humana.",
                        "Actitud de apoyo y solidaridad."
                    )
                ),
                WordEntity(
                    "Estrella",

                    arrayListOf(
                        "Astro luminoso en el espacio.",
                        "En la vida, símbolo de luz y guía.",
                        "En la naturaleza, punto brillante en el cielo nocturno.",
                        "Representación de la grandeza y el brillo.",
                        "Elemento celestial con connotaciones místicas."
                    )
                ),
                WordEntity(
                    "Felicidad",

                    arrayListOf(
                        "Estado de bienestar y satisfacción.",
                        "En la vida, búsqueda constante de alegría.",
                        "En las emociones, sentimiento pleno.",
                        "Experiencia de gozo y contentamiento.",
                        "Objetivo fundamental en la vida humana."
                    )
                ),
                WordEntity(
                    "Fotografía",

                    arrayListOf(
                        "Captura de imágenes mediante una cámara.",
                        "En la vida, arte de congelar momentos.",
                        "En la memoria, registro visual de experiencias.",
                        "Forma de expresión artística y documental.",
                        "Conjunto de técnicas visuales y creativas."
                    )
                ),
                WordEntity(
                    "Flor",

                    arrayListOf(
                        "Órgano reproductor de las plantas.",
                        "En la vida, símbolo de belleza y fragilidad.",
                        "En la naturaleza, elemento decorativo.",
                        "Representación de amor y admiración.",
                        "Variedad de colores y formas en la flora."
                    )
                ),
                WordEntity(
                    "Fascinante",

                    arrayListOf(
                        "Que causa gran interés y admiración.",
                        "En la vida, impactante y cautivador.",
                        "En las experiencias, atractivo y asombroso.",
                        "Capaz de despertar la atención profunda.",
                        "Elemento que provoca fascinación y encanto."
                    )
                ),
                WordEntity(
                    "Fuego",

                    arrayListOf(
                        "Reacción química de combustión.",
                        "En la vida, fuente de calor y luz.",
                        "En la naturaleza, elemento transformador.",
                        "Símbolo de energía y pasión.",
                        "Elemento esencial en la supervivencia humana."
                    )
                ),
                WordEntity(
                    "Familia",

                    arrayListOf(
                        "Grupo de personas unidas por lazos de parentesco.",
                        "En la vida, núcleo fundamental de apoyo.",
                        "En la sociedad, unidad básica.",
                        "Vínculo afectivo y compartido.",
                        "Conjunto de individuos que comparten vivencias y amor."
                    )
                ),
                WordEntity(
                    "Felicidad",

                    arrayListOf(
                        "Estado de bienestar y satisfacción.",
                        "En la vida, búsqueda constante de alegría.",
                        "En las emociones, sentimiento pleno.",
                        "Experiencia de gozo y contentamiento.",
                        "Objetivo fundamental en la vida humana."
                    )
                ),
                WordEntity(
                    "Fantasía",

                    arrayListOf(
                        "Creación imaginativa y no realista.",
                        "En la vida, escape creativo de la realidad.",
                        "En la literatura, género que explora lo extraordinario.",
                        "Elemento de la mente que da rienda suelta a la creatividad.",
                        "Exploración de mundos imaginarios y mágicos."
                    )
                ),
                WordEntity(
                    "Fiesta",

                    arrayListOf(
                        "Celebración alegre y festiva.",
                        "En la vida, momento de alegría y camaradería.",
                        "En la cultura, expresión de tradiciones y rituales.",
                        "Reunión social con música, baile y diversión.",
                        "Celebración colectiva de eventos especiales."
                    )
                ),
                WordEntity(
                    "Fascinante",

                    arrayListOf(
                        "Que causa gran interés y admiración.",
                        "En la vida, impactante y cautivador.",
                        "En las experiencias, atractivo y asombroso.",
                        "Capaz de despertar la atención profunda.",
                        "Elemento que provoca fascinación y encanto."
                    )
                ),
                WordEntity(
                    "Gratitud",

                    arrayListOf(
                        "Sentimiento de reconocimiento y agradecimiento.",
                        "En la vida, actitud de aprecio hacia los demás.",
                        "En las relaciones, expresión de reconocimiento.",
                        "Valoración de las bendiciones y gestos amables.",
                        "Actitud que promueve la conexión y la armonía."
                    )
                ),
                WordEntity(
                    "Galaxia",

                    arrayListOf(
                        "Sistema astronómico compuesto por estrellas, planetas y otros cuerpos celestes.",
                        "En la vida, vasto conjunto de elementos interrelacionados.",
                        "En la astronomía, agrupación de sistemas estelares.",
                        "Estructura cósmica de gran magnitud.",
                        "Objeto de estudio en la exploración espacial."
                    )
                ),
                WordEntity(
                    "Guitarra",

                    arrayListOf(
                        "Instrumento musical de cuerda.",
                        "En la música, fuente de melodías y armonías.",
                        "En la vida, expresión artística y creativa.",
                        "Herramienta de composición y entretenimiento.",
                        "Sonido que evoca emociones y estados de ánimo."
                    )
                ),
                WordEntity(
                    "Generosidad",

                    arrayListOf(
                        "Actitud de dar y compartir de manera desinteresada.",
                        "En la vida, expresión de amabilidad y altruismo.",
                        "En las relaciones, muestra de dar sin esperar nada a cambio.",
                        "Virtud que promueve el bienestar común.",
                        "Elemento clave en la construcción de la comunidad."
                    )
                ),
                WordEntity(
                    "Gracia",

                    arrayListOf(
                        "Elegancia y encanto en el movimiento.",
                        "En la vida, don o regalo divino.",
                        "En las relaciones, actitud amable y considerada.",
                        "Facilidad y fluidez en la ejecución de acciones.",
                        "Atributo que evoca admiración y agradecimiento."
                    )
                ),
                WordEntity(
                    "Gozo",

                    arrayListOf(
                        "Sentimiento de alegría y satisfacción.",
                        "En la vida, experimentar placer y felicidad.",
                        "En las emociones, manifestación de bienestar.",
                        "Sensación de plenitud y regocijo.",
                        "Estado de ánimo positivo y jubiloso."
                    )
                ),
                WordEntity(
                    "Gratitud",

                    arrayListOf(
                        "Sentimiento de reconocimiento y agradecimiento.",
                        "En la vida, actitud de aprecio hacia los demás.",
                        "En las relaciones, expresión de reconocimiento.",
                        "Valoración de las bendiciones y gestos amables.",
                        "Actitud que promueve la conexión y la armonía."
                    )
                ),
                WordEntity(
                    "Galante",

                    arrayListOf(
                        "Elegante, amable y atento.",
                        "En las relaciones, actitud cortés y refinada.",
                        "En la vida, comportamiento caballeroso.",
                        "Cualidad de conquistar con gracia y cortesía.",
                        "Estilo que destaca por su refinamiento y gentileza."
                    )
                ),
                WordEntity(
                    "Gastronomía",

                    arrayListOf(
                        "Arte y práctica de preparar y disfrutar de la buena comida.",
                        "En la vida, exploración de sabores y texturas.",
                        "En la cultura, manifestación de tradiciones culinarias.",
                        "Conjunto de técnicas y conocimientos culinarios.",
                        "Experiencia sensorial y creativa alrededor de la comida."
                    )
                ),
                WordEntity(
                    "Gracia",

                    arrayListOf(
                        "Elegancia y encanto en el movimiento.",
                        "En la vida, don o regalo divino.",
                        "En las relaciones, actitud amable y considerada.",
                        "Facilidad y fluidez en la ejecución de acciones.",
                        "Atributo que evoca admiración y agradecimiento."
                    )
                ),
                WordEntity(
                    "Harmonía",

                    arrayListOf(
                        "Equilibrio y acuerdo entre elementos diversos.",
                        "En la vida, paz y concordia.",
                        "En la música, combinación de sonidos agradables.",
                        "Coexistencia equilibrada de diferentes elementos.",
                        "Estado de equilibrio y coherencia."
                    )
                ),
                WordEntity(
                    "Hogar",

                    arrayListOf(
                        "Lugar donde se vive y se siente protegido.",
                        "En la vida, espacio de seguridad y afecto.",
                        "En la familia, centro de relaciones y convivencia.",
                        "Refugio y espacio personal.",
                        "Símbolo de pertenencia y comodidad."
                    )
                ),
                WordEntity(
                    "Hermosura",

                    arrayListOf(
                        "Calidad de ser hermoso.",
                        "En la vida, apreciación estética.",
                        "En la naturaleza, belleza sublime.",
                        "Cualidad que atrae y cautiva.",
                        "Aspecto exterior agradable y encantador."
                    )
                ),
                WordEntity(
                    "Hospitalidad",

                    arrayListOf(
                        "Cualidad de ser hospitalario y acogedor.",
                        "En la vida, actitud de recibir a otros con amabilidad.",
                        "En la cultura, valoración de recibir a los visitantes.",
                        "Generosidad y cordialidad hacia los demás.",
                        "Bienvenida y atención cálida hacia los invitados."
                    )
                ),
                WordEntity(
                    "Héroe",

                    arrayListOf(
                        "Persona que realiza hazañas extraordinarias.",
                        "En la vida, modelo de valentía y sacrificio.",
                        "En la literatura, personaje central y virtuoso.",
                        "Símbolo de superación y coraje.",
                        "Individuo que se destaca por sus acciones heroicas."
                    )
                ),
                WordEntity(
                    "Harmonía",

                    arrayListOf(
                        "Equilibrio y acuerdo entre elementos diversos.",
                        "En la vida, paz y concordia.",
                        "En la música, combinación de sonidos agradables.",
                        "Coexistencia equilibrada de diferentes elementos.",
                        "Estado de equilibrio y coherencia."
                    )
                ),
                WordEntity(
                    "Humildad",

                    arrayListOf(
                        "Virtud de ser modesto y no presumir.",
                        "En la vida, actitud de reconocer nuestras limitaciones.",
                        "En las relaciones, muestra de respeto y humildad.",
                        "Ausencia de arrogancia y vanidad.",
                        "Cualidad apreciada en la convivencia social."
                    )
                ),
                WordEntity(
                    "Horizonte",

                    arrayListOf(
                        "Línea que separa la tierra y el cielo.",
                        "En la vida, perspectiva y expectativa de futuro.",
                        "En la naturaleza, límite visual.",
                        "Símbolo de expansión y posibilidades.",
                        "Conjunto de paisajes y posibilidades a descubrir."
                    )
                ),
                WordEntity(
                    "Harmonía",

                    arrayListOf(
                        "Equilibrio y acuerdo entre elementos diversos.",
                        "En la vida, paz y concordia.",
                        "En la música, combinación de sonidos agradables.",
                        "Coexistencia equilibrada de diferentes elementos.",
                        "Estado de equilibrio y coherencia."
                    )
                ),
                WordEntity(
                    "Honestidad",

                    arrayListOf(
                        "Calidad de ser honesto y veraz.",
                        "En la vida, integridad y rectitud en el comportamiento.",
                        "En las relaciones, confianza y transparencia.",
                        "Principio ético fundamental.",
                        "Valoración de la verdad y la sinceridad."
                    )
                ),
                WordEntity(
                    "Ilusión",

                    arrayListOf(
                        "Percepción engañosa de la realidad.",
                        "En la vida, esperanza y entusiasmo.",
                        "En las emociones, sensación de anticipación positiva.",
                        "Deseo intenso y optimista.",
                        "Construcción mental de un futuro deseado."
                    )
                ),
                WordEntity(
                    "Inspiración",

                    arrayListOf(
                        "Estímulo creativo o motivador.",
                        "En la vida, fuente de ideas y entusiasmo.",
                        "En la creatividad, influencia inspiradora.",
                        "Impulso para la acción positiva.",
                        "Conexión con la fuente de la creatividad."
                    )
                ),
                WordEntity(
                    "Integridad",

                    arrayListOf(
                        "Calidad de ser íntegro y honesto.",
                        "En la vida, coherencia en principios y valores.",
                        "En las acciones, cumplir con la ética y la moral.",
                        "Principio de totalidad y rectitud.",
                        "Respeto por la consistencia y la unidad."
                    )
                ),
                WordEntity(
                    "Identidad",

                    arrayListOf(
                        "Conjunto de características que definen a una persona o cosa.",
                        "En la vida, sentido de quién uno es.",
                        "En la sociedad, reconocimiento y pertenencia.",
                        "Expresión de singularidad y autenticidad.",
                        "Conjunto de rasgos que distinguen a algo o alguien."
                    )
                ),
                WordEntity(
                    "Innovación",

                    arrayListOf(
                        "Creación o adopción de nuevas ideas o métodos.",
                        "En la vida, búsqueda de soluciones creativas.",
                        "En la tecnología, avance y cambio disruptivo.",
                        "Fomento de la mejora y el progreso.",
                        "Desarrollo de ideas novedosas y eficientes."
                    )
                ),
                WordEntity(
                    "Ilusión",

                    arrayListOf(
                        "Percepción engañosa de la realidad.",
                        "En la vida, esperanza y entusiasmo.",
                        "En las emociones, sensación de anticipación positiva.",
                        "Deseo intenso y optimista.",
                        "Construcción mental de un futuro deseado."
                    )
                ),
                WordEntity(
                    "Inclusión",

                    arrayListOf(
                        "Práctica de incluir a todos de manera equitativa.",
                        "En la vida, respeto a la diversidad.",
                        "En la sociedad, promoción de la igualdad.",
                        "Fomento de la participación de todos.",
                        "Reconocimiento y valoración de la diversidad."
                    )
                ),
                WordEntity(
                    "Imaginación",

                    arrayListOf(
                        "Facultad de crear imágenes y situaciones en la mente.",
                        "En la vida, capacidad de visualizar posibilidades.",
                        "En la creatividad, fuente de ideas innovadoras.",
                        "Exploración de mundos ficticios y creativos.",
                        "Elemento fundamental en la formación de ideas."
                    )
                ),
                WordEntity(
                    "Inspiración",

                    arrayListOf(
                        "Estímulo creativo o motivador.",
                        "En la vida, fuente de ideas y entusiasmo.",
                        "En la creatividad, influencia inspiradora.",
                        "Impulso para la acción positiva.",
                        "Conexión con la fuente de la creatividad."
                    )
                ),
                WordEntity(
                    "Integridad",

                    arrayListOf(
                        "Calidad de ser íntegro y honesto.",
                        "En la vida, coherencia en principios y valores.",
                        "En las acciones, cumplir con la ética y la moral.",
                        "Principio de totalidad y rectitud.",
                        "Respeto por la consistencia y la unidad."
                    )
                ),
                WordEntity(
                    "Jardín",

                    arrayListOf(
                        "Espacio cultivado con plantas y flores.",
                        "En la vida, lugar de belleza y tranquilidad.",
                        "En la naturaleza, área verde y decorativa.",
                        "Entorno armonioso de vegetación.",
                        "Área destinada al cultivo y cuidado de plantas."
                    )
                ),
                WordEntity(
                    "Joya",

                    arrayListOf(
                        "Objeto de gran valor y belleza.",
                        "En la vida, símbolo de aprecio y amor.",
                        "En la moda, adorno preciado.",
                        "Tesoro que evoca emociones especiales.",
                        "Elemento significativo y precioso."
                    )
                ),
                WordEntity(
                    "Jirafa",

                    arrayListOf(
                        "Mamífero de cuello largo y patas largas.",
                        "En la naturaleza, animal africano singular.",
                        "En la vida, símbolo de elegancia y singularidad.",
                        "Criatura herbívora y social.",
                        "Atractivo y distintivo en la fauna."
                    )
                ),
                WordEntity(
                    "Jazz",

                    arrayListOf(
                        "Género musical de origen afroamericano.",
                        "En la música, estilo improvisado y vibrante.",
                        "En la cultura, expresión artística única.",
                        "Conjunto de ritmos y armonías creativas.",
                        "Forma de expresión que evoluciona constantemente."
                    )
                ),
                WordEntity(
                    "Jet",

                    arrayListOf(
                        "Avión propulsado por motores a reacción.",
                        "En el transporte, medio rápido y eficiente.",
                        "En la tecnología, símbolo de velocidad y modernidad.",
                        "Elemento clave en la aviación contemporánea.",
                        "Máquina que utiliza la fuerza del chorro para desplazarse."
                    )
                ),
                WordEntity(
                    "Jardín",

                    arrayListOf(
                        "Espacio cultivado con plantas y flores.",
                        "En la vida, lugar de belleza y tranquilidad.",
                        "En la naturaleza, área verde y decorativa.",
                        "Entorno armonioso de vegetación.",
                        "Área destinada al cultivo y cuidado de plantas."
                    )
                ),
                WordEntity(
                    "Juego",

                    arrayListOf(
                        "Actividad lúdica o deportiva.",
                        "En la vida, forma de entretenimiento.",
                        "En la infancia, herramienta de aprendizaje.",
                        "Competición amistosa o recreativa.",
                        "Elemento fundamental en el desarrollo humano."
                    )
                ),
                WordEntity(
                    "Juventud",

                    arrayListOf(
                        "Período de la vida entre la niñez y la edad adulta.",
                        "En la vida, etapa de descubrimiento y crecimiento.",
                        "En la sociedad, fuerza impulsora del cambio.",
                        "Momento de energía y exploración.",
                        "Conjunto de características propias de la juventud."
                    )
                ),
                WordEntity(
                    "Juego",

                    arrayListOf(
                        "Actividad lúdica o deportiva.",
                        "En la vida, forma de entretenimiento.",
                        "En la infancia, herramienta de aprendizaje.",
                        "Competición amistosa o recreativa.",
                        "Elemento fundamental en el desarrollo humano."
                    )
                ),
                WordEntity(
                    "Jazmín",

                    arrayListOf(
                        "Planta de flores blancas y fragantes.",
                        "En la naturaleza, arbusto ornamental.",
                        "En la vida, símbolo de pureza y delicadeza.",
                        "Aroma dulce y distintivo.",
                        "Flor utilizada en perfumería y decoración."
                    )
                ),
                WordEntity(
                    "Kiwi",

                    arrayListOf(
                        "Fruta pequeña y peluda de color marrón o verde.",
                        "En la alimentación, fuente de vitamina C.",
                        "En la naturaleza, originaria de Nueva Zelanda.",
                        "Sabor dulce y refrescante.",
                        "Versátil en la preparación de alimentos y bebidas."
                    )
                ),
                WordEntity(
                    "Kilogramo",

                    arrayListOf(
                        "Unidad de medida de masa en el sistema internacional.",
                        "En la física, masa del prototipo internacional del kilogramo.",
                        "Equivale a mil gramos.",
                        "Fundamental en la medición de peso.",
                        "Utilizado en contextos científicos y cotidianos."
                    )
                ),
                WordEntity(
                    "Karaoke",

                    arrayListOf(
                        "Entretenimiento musical donde las personas cantan sobre una pista grabada.",
                        "En la cultura, actividad social y divertida.",
                        "Uso de micrófonos y letras en pantalla.",
                        "Popular en reuniones y eventos sociales.",
                        "Forma de expresión artística y recreativa."
                    )
                ),
                WordEntity(
                    "Koala",

                    arrayListOf(
                        "Mamífero marsupial arbóreo originario de Australia.",
                        "En la naturaleza, se alimenta principalmente de hojas de eucalipto.",
                        "Animal emblemático de Australia.",
                        "Parece un oso pequeño con pelaje gris y orejas redondas.",
                        "Especie vulnerable en algunos lugares debido a la pérdida de hábitat."
                    )
                ),
                WordEntity(
                    "Kárate",

                    arrayListOf(
                        "Arte marcial de origen japonés.",
                        "En la práctica, combina técnicas de ataque y defensa.",
                        "Disciplina que fomenta el desarrollo físico y mental.",
                        "Uso de golpes, patadas y bloqueos.",
                        "Sistema de autodefensa y mejora personal."
                    )
                ),
                WordEntity(
                    "Química",

                    arrayListOf(
                        "Ciencia que estudia la composición y propiedades de la materia.",
                        "En la educación, materia de estudio.",
                        "En la vida, presente en diversas disciplinas científicas.",
                        "Interacción de átomos y moléculas.",
                        "Conjunto de procesos y reacciones químicas."
                    )
                ),
                WordEntity(
                    "Querencia",

                    arrayListOf(
                        "Lugar o ambiente en el que uno se siente seguro y cómodo.",
                        "En la vida, sentido de pertenencia y arraigo.",
                        "En las emociones, apego y afecto hacia un lugar.",
                        "Vínculo emocional con un entorno específico.",
                        "Concepto asociado con la tranquilidad y la familiaridad."
                    )
                ),
                WordEntity(
                    "Querido",

                    arrayListOf(
                        "Adjetivo que expresa cariño y afecto.",
                        "En las relaciones, persona amada y apreciada.",
                        "En la vida, valoración especial.",
                        "Término afectuoso hacia seres queridos.",
                        "Sentimiento de aprecio y conexión emocional."
                    )
                ),
                WordEntity(
                    "Quetzal",

                    arrayListOf(
                        "Ave de plumaje colorido y brillante originaria de América Central.",
                        "En la naturaleza, símbolo de libertad y belleza.",
                        "En la cultura maya, asociada con la deidad Quetzalcóatl.",
                        "Nombre de la moneda oficial de Guatemala.",
                        "Especie protegida debido a la pérdida de hábitat."
                    )
                ),
                WordEntity(
                    "Química",

                    arrayListOf(
                        "Ciencia que estudia la composición y propiedades de la materia.",
                        "En la educación, materia de estudio.",
                        "En la vida, presente en diversas disciplinas científicas.",
                        "Interacción de átomos y moléculas.",
                        "Conjunto de procesos y reacciones químicas."
                    )
                ),
                WordEntity(
                    "Quijote",

                    arrayListOf(
                        "Personaje principal de la novela 'Don Quijote de la Mancha'.",
                        "En la literatura, obra maestra de Miguel de Cervantes.",
                        "Símbolo de idealismo y caballerosidad.",
                        "Aventurero que lucha contra molinos de viento.",
                        "Figura literaria que representa la búsqueda de la perfección."
                    )
                ),
                WordEntity(
                    "Querencia",

                    arrayListOf(
                        "Lugar o ambiente en el que uno se siente seguro y cómodo.",
                        "En la vida, sentido de pertenencia y arraigo.",
                        "En las emociones, apego y afecto hacia un lugar.",
                        "Vínculo emocional con un entorno específico.",
                        "Concepto asociado con la tranquilidad y la familiaridad."
                    )
                ),
                WordEntity(
                    "Querido",

                    arrayListOf(
                        "Adjetivo que expresa cariño y afecto.",
                        "En las relaciones, persona amada y apreciada.",
                        "En la vida, valoración especial.",
                        "Término afectuoso hacia seres queridos.",
                        "Sentimiento de aprecio y conexión emocional."
                    )
                ),
                WordEntity(
                    "Quasar",

                    arrayListOf(
                        "Objeto astronómico extremadamente luminoso y distante.",
                        "En la astronomía, núcleo activo de una galaxia.",
                        "Fuente de energía que emite radiación intensa.",
                        "Estudio importante en la cosmología.",
                        "Fenómeno celestial de gran interés científico."
                    )
                ),
                WordEntity(
                    "Quórum",

                    arrayListOf(
                        "Número mínimo de miembros necesario para tomar decisiones.",
                        "En la política, requisito para la validez de una reunión.",
                        "En las asambleas, cantidad de participantes requeridos.",
                        "Elemento esencial en la toma de decisiones colectivas.",
                        "Concepto aplicado en diversos ámbitos y organizaciones."
                    )
                )
            )
            withContext(Dispatchers.IO) {
                words.forEach {
                    val word = database.wordDao().getWord(it.name)
                    if (word == null) database.wordDao().insertWord(it)
                }
            }
        }
    }



}