package com.example.quizgame.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quizgame.R
import com.example.quizgame.data.dao.PlayerDao
import com.example.quizgame.data.dao.QFromImageDao
import com.example.quizgame.data.dao.QImageDao
import com.example.quizgame.data.dao.QTextDao
import com.example.quizgame.data.entities.PlayerEntity
import com.example.quizgame.data.entities.QFromImageEntity
import com.example.quizgame.data.entities.QImageEntity
import com.example.quizgame.data.entities.QTextEntity
import com.example.quizgame.data.typeconverters.AnswersConverter
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Base de datos de la aplicación
 */

@Database(
    entities = [PlayerEntity::class, QFromImageEntity::class, QImageEntity::class, QTextEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(AnswersConverter::class)
abstract class AppDatabase : RoomDatabase() {
    //Daos of all entities:
    abstract fun playerDao(): PlayerDao
    abstract fun qFromImageDao(): QFromImageDao
    abstract fun qImageDao(): QImageDao
    abstract fun qTextDao(): QTextDao


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
            Log.d("DB","DATABASE BUILD INIT")
            val databaseBuilder = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "QuizGameDB"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //Init insert data (default data)
                        GlobalScope.launch {
                            Log.d("BD","CALLBACK INIT")
                            insertInitialData(getInstance(context))
                            Log.d("BD","CALLBACK END")
                        }
                    }
                })
                .build()
            Log.d("DB","DATABASE BUILD END")
            return databaseBuilder
        }

        //Initials inserts:
        private suspend fun insertsInitialPlayers( playerDao: PlayerDao) {
            // Conjunto de datos de prueba
            val player1 = PlayerEntity(name = "Rubén", score = 0)
            val player2 = PlayerEntity(name = "Jorge", score = 0)
            val player3 = PlayerEntity(name = "Sebas", score = 0)

            withContext(Dispatchers.IO){
                Log.d("DB", "INSERT PLAYERS")
                playerDao.insertPlayer(player1)
                playerDao.insertPlayer(player2)
                playerDao.insertPlayer(player3)
                Log.d("DB", "PLAYERS INSERTED")
            }
        }
        private suspend fun insertInitialTextQuestions(qTextDao: QTextDao) {
            val textQuestions = listOf(
                QTextEntity(
                    "¿Cuál es el núcleo central de un átomo?",
                    1,
                    listOf("Neutrón", "Protón", "Electrón", "Positrón"),
                    "Science"
                ),
                QTextEntity(
                    "¿Cuál es la fórmula química del agua?",
                    1,
                    listOf("CO2", "H2O", "O3", "CH4"),
                    "Science"
                ),
                QTextEntity(
                    "¿Cuál es el planeta más cercano al Sol?",
                    2,
                    listOf("La Tierra", "Júpiter", "Mercurio", "Marte"),
                    "Science"
                ),
                QTextEntity(
                    "¿Cuál es la unidad básica de la vida?",
                    1,
                    listOf("Átomo", "Célula", "Molécula", "Proteína"),
                    "Science"
                ),
                QTextEntity(
                    "¿Cuál es la fórmula química del dióxido de carbono?",
                    0,
                    listOf("CO2", "H2O", "O3", "CH4"),
                    "Science"
                ),
                QTextEntity(
                    "¿Cuál es la fuerza que mantiene a los planetas en órbita alrededor del Sol?",
                    0,
                    listOf(
                        "Gravedad",
                        "Electromagnetismo",
                        "Fuerza nuclear fuerte",
                        "Fuerza nuclear débil"
                    ),
                    "Science"
                ),
                QTextEntity(
                    "¿Como tranforman las plantas la luz en energía?",
                    0,
                    listOf("Fotosíntesis", "Respiración", "Transpiración", "Fotólisis"),
                    "Science"
                ),
                QTextEntity(
                    "¿Cuál es el elemento químico más abundante en la corteza terrestre?",
                    2,
                    listOf("Hierro", "Silicio", "Oxígeno", "Aluminio"),
                    "Science"
                ),
                QTextEntity(
                    "¿Cuál es la capa más externa de la Tierra?",
                    2,
                    listOf("Núcleo", "Manto", "Corteza", "Núcleo interno"),
                    "Science"
                ),
                QTextEntity(
                    "¿Cuál es la velocidad de la luz en el vacío?",
                    0,
                    listOf(
                        "299,792,458 metros por segundo",
                        "186,282 millas por segundo",
                        "100,000 kilómetros por segundo",
                        "3,600,000,000 metros por segundo"
                    ),
                    "Science"
                ), QTextEntity(
                    "¿Quién fue el primer presidente de los EEUU?",
                    2,
                    listOf(
                        "Thomas Jefferson",
                        "Benjamin Franklin",
                        "George Washington",
                        "John Adams"
                    ),
                    "History"
                ),
                QTextEntity(
                    "¿Cuando se firmó la Declaración de Independencia de los EEUU?",
                    2,
                    listOf("1789", "1792", "1776", "1812"),
                    "History"
                ),
                QTextEntity(
                    "¿Cuál fue el imperio más grande de la historia antigua?",
                    2,
                    listOf(
                        "El Imperio Romano",
                        "El Imperio Persa",
                        "El Imperio Mongol",
                        "El Imperio Británico"
                    ),
                    "History"
                ),
                QTextEntity(
                    "¿Quién fue el líder de la Revolución Rusa en 1917?",
                    0,
                    listOf("Vladimir Lenin", "Josef Stalin", "Nikolai Romanov", "Leon Trotsky"),
                    "History"
                ),
                QTextEntity(
                    "¿Cuál fue el evento que marcó el comienzo de la Segunda Guerra Mundial?",
                    1,
                    listOf(
                        "El ataque a Pearl Harbor",
                        "La invasión de Polonia",
                        "La Batalla de Stalingrado",
                        "El Blitz en Londres"
                    ),
                    "History"
                ),
                QTextEntity(
                    "¿Quién fue el líder de la Revolución Cubana en 1959?",
                    0,
                    listOf("Fidel Castro", "Che Guevara", "Batista", "Somoza"),
                    "History"
                ),
                QTextEntity(
                    "¿En qué año se firmó el Tratado de Versalles, que puso fin a la Primera Guerra Mundial?",
                    2,
                    listOf("1918", "1920", "1919", "1922"),
                    "History"
                ),
                QTextEntity(
                    "¿Quién no estuvo en la conferencia de Yalta en la Segunda Guerra Mundial?",
                    3,
                    listOf(
                        "Franklin D. Roosevelt",
                        "Winston Churchill",
                        "Joseph Stalin",
                        "Adolf Hitler"
                    ),
                    "History"
                ),
                QTextEntity(
                    "¿Qué derechos civiles buscaba poner fin a la segregación racial en EEUU en los 60's?",
                    2,
                    listOf(
                        "Movimiento de Derechos Humanos",
                        "Movimiento de Mujeres",
                        "Movimiento de los Derechos Civiles",
                        "Movimiento Hippie"
                    ),
                    "History"
                ),
                QTextEntity(
                    "¿Cuál fue el acuerdo que puso fin a la Guerra de Vietnam en 1975?",
                    1,
                    listOf(
                        "Acuerdo de Ginebra",
                        "Acuerdo de París",
                        "Acuerdo de Hanoi",
                        "Acuerdo de Saigón"
                    ),
                    "History"
                ),
                QTextEntity(
                    "¿Cuál es el deporte que se juega con canastas y pelota naranja?",
                    0,
                    listOf("Baloncesto", "Fútbol", "Béisbol", "Golf"),
                    "Sports"
                ),
                QTextEntity(
                    "¿Cuántos jugadores puede un equipo de fútbol tener en el campo?",
                    1,
                    listOf("10", "11", "9", "12"),
                    "Sports"
                ),
                QTextEntity(
                    "¿En qué deporte se utiliza una raqueta y red?",
                    0,
                    listOf("Tenis", "Fútbol", "Tenis de Mesa", "Vóley"),
                    "Sports"
                ),
                QTextEntity(
                    "¿Qué deporte cuenta con 18 hoyos?",
                    2,
                    listOf("Fútbol", "Baloncesto", "Golf", "Atletismo"),
                    "Sports"
                ),
                QTextEntity(
                    "¿Qué deporte se juega con un bate y bola?",
                    2,
                    listOf("Baloncesto", "Fútbol", "Béisbol", "Golf"),
                    "Sports"
                ),
                QTextEntity(
                    "¿Cuál es el deporte que se juega con un disco volador?",
                    3,
                    listOf("Natación", "Vóley", "Atletismo", "Ultimate Frisbee"),
                    "Sports"
                ),
                QTextEntity(
                    "¿Cuál de los siguientes no es un deporte olímpico?",
                    2,
                    listOf("Natación", "Fútbol", "Patinaje", "Esgrima"),
                    "Sports"
                ),
                QTextEntity(
                    "¿En qué deporte un jugador puede anotar un 'touchdown'?",
                    1,
                    listOf("Fútbol", "Fútbol americano", "Baloncesto", "Béisbol"),
                    "Sports"
                ),
                QTextEntity(
                    "¿Cuál es el deporte que se juega con palo y pelota en campo de hierba?",
                    2,
                    listOf("Fútbol", "Béisbol", "Críquet", "Vóley"),
                    "Sports"
                ),
                QTextEntity(
                    "¿Cuál es el deporte que se juega en una piscina con carriles?",
                    0,
                    listOf("Natación", "Vóley", "Waterpolo", "Atletismo"),
                    "Sports"
                ),
                QTextEntity(
                    "¿En qué serie de televisión se encuentra el Trono de Hierro?",
                    2,
                    listOf(
                        "The Walking Dead",
                        "Breaking Bad",
                        "Game of Thrones",
                        "Stranger Things"
                    ),
                    "Series"
                ),
                QTextEntity(
                    "¿Quién es el protagonista de la serie 'Breaking Bad'?",
                    0,
                    listOf("Walter White", "Jesse Pinkman", "Saul Goodman", "Skyler White"),
                    "Series"
                ),
                QTextEntity(
                    "¿En qué serie de televisión los personajes viajan al 'upside down'?",
                    3,
                    listOf("Lost", "The X-Files", "The Haunting of Hill House", "Stranger Things"),
                    "Series"
                ),
                QTextEntity(
                    "¿Cuál es la serie que sigue las aventuras de Walter White?",
                    1,
                    listOf("The Sopranos", "Breaking Bad", "The Wire", "The Shield"),
                    "Series"
                ),
                QTextEntity(
                    "¿Qué serie sigue las vidas de unos amigos en el Central Park de Nueva York?",
                    0,
                    listOf("Friends", "The Office", "How I Met Your Mother", "The Big Bang Theory"),
                    "Series"
                ),
                QTextEntity(
                    "¿Quién interpreta a Tony Stark en 'Iron Man' y 'The Avengers'?",
                    2,
                    listOf("Chris Hemsworth", "Chris Evans", "Robert Downey Jr.", "Mark Ruffalo"),
                    "Series"
                ),
                QTextEntity(
                    "¿Cuál es la serie que sigue la vida de una familia mafiosa en Nueva Jersey?",
                    2,
                    listOf("Boardwalk Empire", "The Wire", "The Sopranos", "The Godfather"),
                    "Series"
                ),
                QTextEntity(
                    "¿Qué serie de televisión presenta a un científico loco y a su nieto aventurero en viajes interdimensionales?",
                    1,
                    listOf("The X-Files", "Rick and Morty", "Futurama", "Adventure Time"),
                    "Series"
                ),
                QTextEntity(
                    "¿En qué serie un detective resuelve casos en Miami usando un código de ética inusual?",
                    0,
                    listOf(
                        "Dexter",
                        "CSI: Crime Scene Investigation",
                        "Mindhunter",
                        "The Mentalist"
                    ),
                    "Series"
                ),
                QTextEntity(
                    "¿Qué serie trata sobre las desventuras de una familia que se muda a una casa embrujada en Los Ángeles?",
                    0,
                    listOf(
                        "American Horror Story",
                        "Game of Thrones",
                        "The Big Bang Theory",
                        "Breaking Bad"
                    ),
                    "Series"
                ),
                QTextEntity(
                    "¿Cuál es el nombre de la partícula subatómica que tiene carga eléctrica negativa?",
                    2,
                    listOf("Neutrón", "Protón", "Electrón", "Positrón"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el único planeta del sistema solar que rota en dirección opuesta a la mayoría de los demás planetas?",
                    1,
                    listOf("Mercurio", "Venus", "Tierra", "Marte"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se publicó la teoría de la relatividad general de Albert Einstein?",
                    1,
                    listOf("1905", "1915", "1925", "1935"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el componente principal del gas natural?",
                    0,
                    listOf("Metano", "Etileno", "Propano", "Butano"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la velocidad de la luz en el vacío?",
                    0,
                    listOf("299,792,458 metros por segundo", "150,000,000 metros por segundo", "200,000,000 metros por segundo", "250,000,000 metros por segundo"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el número atómico del plutonio?",
                    0,
                    listOf("94", "92", "96", "98"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se descubrió el bosón de Higgs?",
                    0,
                    listOf("2012", "2008", "2010", "2015"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el principal constituyente del granito?",
                    1,
                    listOf("Cuarzo", "Feldespato", "Mica", "Hornblenda"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la montaña más alta del sistema solar?",
                    1,
                    listOf("Monte Everest", "Olimpo", "K2", "Makalu"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el compuesto químico del óxido nitroso?",
                    2,
                    listOf("NO2", "N2O3", "N2O", "NO"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se lanzó el telescopio espacial Hubble?",
                    1,
                    listOf("1988", "1990", "1995", "2000"),
                    "Hard"
                ),QTextEntity(
                    "¿Cuál es el símbolo químico del elemento Oro?",
                    0,
                    listOf("Au", "Ag", "Fe", "Cu"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el planeta más grande del sistema solar?",
                    2,
                    listOf("Tierra", "Marte", "Júpiter", "Saturno"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la fórmula química del dióxido de carbono?",
                    1,
                    listOf("CO", "CO2", "C2O", "C2O3"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?",
                    0,
                    listOf("1945", "1950", "1930", "1960"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el componente principal del aire?",
                    1,
                    listOf("Dióxido de carbono", "Nitrógeno", "Oxígeno", "Argón"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién formuló la teoría de la evolución por selección natural?",
                    1,
                    listOf("Gregor Mendel", "Charles Darwin", "Alfred Russel Wallace", "Jean-Baptiste Lamarck"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la montaña más alta de América del Norte?",
                    0,
                    listOf("Monte McKinley", "Monte Logan", "Monte Whitney", "Monte Elbert"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué siglo se llevó a cabo la Revolución Industrial?",
                    0,
                    listOf("Siglo XVIII", "Siglo XIX", "Siglo XVII", "Siglo XX"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el principal constituyente del humo del tabaco que causa cáncer?",
                    0,
                    listOf("Nicotina", "Alquitrán", "Monóxido de carbono", "Arsénico"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año empezó la Guerra de los Cien Años?",
                    1,
                    listOf("1320", "1337", "1401", "1453"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la ciudad más densamente poblada del mundo?",
                    1,
                    listOf("Pekín", "Tokio", "Shanghái", "Estambul"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el proceso químico responsable de la corrosión del hierro?",
                    3,
                    listOf("Oxidación", "Reducción", "Fotólisis", "Electrólisis"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién escribió la obra 'Cien años de soledad'?",
                    0,
                    listOf("Gabriel García Márquez", "Mario Vargas Llosa", "Isabel Allende", "Julio Cortázar"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la partícula subatómica con carga positiva?",
                    1,
                    listOf("Neutrón", "Protón", "Electrón", "Positrón"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?",
                    0,
                    listOf("1776", "1789", "1801", "1824"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el país más extenso del mundo?",
                    0,
                    listOf("Rusia", "Canadá", "China", "Estados Unidos"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién descubrió América en 1492?",
                    2,
                    listOf("Fernando de Magallanes", "Vasco da Gama", "Cristóbal Colón", "Juan Sebastián Elcano"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el río más largo del mundo?",
                    0,
                    listOf("Amazonas", "Nilo", "Misisipi", "Yangtsé"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el proceso químico que convierte la leche en yogur?",
                    0,
                    listOf("Fermentación láctica", "Destilación", "Combustión", "Oxidación"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el metal más abundante en la corteza terrestre?",
                    1,
                    listOf("Hierro", "Aluminio", "Cobre", "Plomo"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Mongolia?",
                    1,
                    listOf("Pekín", "Ulán Bator", "Astana", "Seúl"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el componente activo en la marihuana?",
                    0,
                    listOf("THC", "CBD", "Cocaína", "Morfina"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la Revolución Rusa?",
                    0,
                    listOf("1917", "1923", "1905", "1930"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién escribió 'Romeo y Julieta'?",
                    0,
                    listOf("William Shakespeare", "Jane Austen", "Charles Dickens", "Fyodor Dostoevsky"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el segundo planeta más cercano al sol?",
                    1,
                    listOf("Mercurio", "Venus", "Marte", "Júpiter"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el autor de 'El Gran Gatsby'?",
                    0,
                    listOf("F. Scott Fitzgerald", "Ernest Hemingway", "J.D. Salinger", "William Faulkner"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el elemento químico más ligero?",
                    0,
                    listOf("Hidrógeno", "Helio", "Litio", "Oxígeno"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se inauguró el Canal de Panamá?",
                    2,
                    listOf("1904", "1910", "1914", "1920"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Nueva Zelanda?",
                    2,
                    listOf("Sídney", "Melbourne", "Wellington", "Auckland"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el proceso biológico en el que las plantas convierten la luz solar en energía?",
                    0,
                    listOf("Fotosíntesis", "Respiración", "Mitosis", "Fermentación"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la Revolución Francesa?",
                    0,
                    listOf("1789", "1795", "1801", "1810"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la distancia promedio de la Tierra a la Luna?",
                    2,
                    listOf("250,000 km", "300,000 km", "384,400 km", "400,000 km"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el instrumento musical más antiguo?",
                    0,
                    listOf("Flauta", "Arpa", "Lira", "Tambor"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién escribió '1984'?",
                    0,
                    listOf("George Orwell", "Aldous Huxley", "Ray Bradbury", "Philip K. Dick"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Egipto?",
                    1,
                    listOf("Bagdad", "El Cairo", "Riad", "Teherán"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la Organización Mundial de la Salud (OMS)?",
                    2,
                    listOf("1945", "1950", "1948", "1970"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el período de rotación de Mercurio alrededor de su eje?",
                    1,
                    listOf("24 horas", "59 días", "88 días", "365 días"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién descubrió la radioactividad?",
                    3,
                    listOf("Marie Curie", "Ernest Rutherford", "Niels Bohr", "Henri Becquerel"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Canadá?",
                    0,
                    listOf("Ottawa", "Toronto", "Montreal", "Vancouver"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el proceso biológico responsable de la formación de gametos?",
                    1,
                    listOf("Meiosis", "Mitosis", "Fotosíntesis", "Replicación"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién pintó la Mona Lisa?",
                    2,
                    listOf("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el gas más abundante en la atmósfera terrestre?",
                    0,
                    listOf("Nitrógeno", "Oxígeno", "Argón", "Dióxido de carbono"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se inauguró el Canal de Suez?",
                    1,
                    listOf("1859", "1869", "1879", "1889"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la velocidad terminal de un objeto en caída libre?",
                    0,
                    listOf("No hay velocidad terminal en el vacío", "9.8 m/s²", "20 m/s", "30 m/s"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién desarrolló la teoría de los arquetipos en psicología?",
                    2,
                    listOf("Sigmund Freud", "John B. Watson", "Carl Jung", "Ivan Pavlov"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la longitud del ecuador terrestre?",
                    2,
                    listOf("20,000 km", "30,000 km", "40,000 km", "50,000 km"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el periodo orbital de la Estación Espacial Internacional (ISS)?",
                    1,
                    listOf("90 minutos", "120 minutos", "180 minutos", "240 minutos"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se inventó la imprenta?",
                    0,
                    listOf("1440", "1500", "1550", "1600"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la enzima responsable de la descomposición del peróxido de hidrógeno?",
                    2,
                    listOf("Lipasa", "Amilasa", "Catalasa", "Proteasa"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién fue el primer ser humano en el espacio?",
                    0,
                    listOf("Yuri Gagarin", "Neil Armstrong", "Buzz Aldrin", "Valentina Tereshkova"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el rango de pH del agua pura a temperatura ambiente?",
                    2,
                    listOf("1-3", "4-6", "6.5-8.5", "8-10"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el proceso biológico que convierte la glucosa en energía en las células?",
                    0,
                    listOf("Respiración celular", "Fotosíntesis", "Gluconeogénesis", "Fermentación"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se firmó el Tratado de Versalles?",
                    2,
                    listOf("1915", "1918", "1919", "1923"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el símbolo químico del tungsteno?",
                    1,
                    listOf("W", "Tg", "Tu", "Tw"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién propuso la teoría heliocéntrica del sistema solar?",
                    1,
                    listOf("Ptolomeo", "Copérnico", "Galileo", "Kepler"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el metal más denso?",
                    0,
                    listOf("Osmio", "Iridio", "Platino", "Paladio"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año inició la Revolución Industrial en Japón?",
                    2,
                    listOf("1700", "1800", "1890", "1900"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el río más largo de Asia?",
                    0,
                    listOf("Río Yangtsé", "Río Ganges", "Río Amur", "Río Mekong"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién descubrió el electrón?",
                    1,
                    listOf("Ernest Rutherford", "J.J. Thomson", "Niels Bohr", "Max Planck"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el único planeta del sistema solar que rota en sentido horario?",
                    0,
                    listOf("Venus", "Urano", "Neptuno", "Marte"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la independencia de la India?",
                    2,
                    listOf("1945", "1950", "1947", "1960"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el nombre del proceso por el cual las plantas convierten la luz en energía química?",
                    0,
                    listOf("Fotosíntesis", "Quimiosíntesis", "Respiración celular", "Transpiración"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la Revolución Industrial en Alemania?",
                    2,
                    listOf("1700", "1800", "1848", "1871"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el elemento más abundante en la corteza terrestre?",
                    0,
                    listOf("Oxígeno", "Silicio", "Aluminio", "Hierro"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién formuló la teoría de la relatividad general?",
                    3,
                    listOf("Isaac Newton", "Max Planck", "Niels Bohr", "Albert Einstein"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Sudáfrica?",
                    1,
                    listOf("Pretoria", "Ciudad del Cabo", "Bloemfontein", "Johannesburgo"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el ácido presente en el jugo gástrico del estómago?",
                    0,
                    listOf("Ácido clorhídrico", "Ácido acético", "Ácido sulfúrico", "Ácido cítrico"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la Liga de Naciones?",
                    2,
                    listOf("1918", "1920", "1919", "1930"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la velocidad de la luz en el vidrio?",
                    3,
                    listOf("299,792 km/s", "225,000 km/s", "150,000 km/s", "200,000 km/s"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién escribió 'Don Quijote de la Mancha'?",
                    0,
                    listOf("Miguel de Cervantes", "Garcilaso de la Vega", "Lope de Vega", "Federico García Lorca"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el metal más caro del mundo?",
                    0,
                    listOf("Rodio", "Oro", "Platino", "Paladio"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el compuesto químico responsable del olor característico de la lluvia?",
                    0,
                    listOf("Geosmina", "Ozono", "Hidrógeno", "Amoníaco"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se produjo la Revolución Mexicana?",
                    1,
                    listOf("1900", "1910", "1920", "1930"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la enzima que descompone el almidón en el sistema digestivo humano?",
                    1,
                    listOf("Lipasa", "Amilasa", "Proteasa", "Maltasa"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién escribió 'El principito'?",
                    1,
                    listOf("J.R.R. Tolkien", "Antoine de Saint-Exupéry", "Gabriel García Márquez", "Hermann Hesse"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Tailandia?",
                    0,
                    listOf("Bangkok", "Phuket", "Chiang Mai", "Pattaya"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la independencia de Brasil?",
                    1,
                    listOf("1808", "1822", "1840", "1867"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la hormona responsable de la regulación del sueño y vigilia?",
                    1,
                    listOf("Insulina", "Melatonina", "Adrenalina", "Serotonina"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién fue el primer emperador de China?",
                    3,
                    listOf("Sun Yat-sen", "Mao Zedong", "Kangxi", "Qin Shi Huang"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el gas noble más abundante en la Tierra?",
                    0,
                    listOf("Argón", "Helio", "Neón", "Kriptón"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la Cruz Roja Internacional?",
                    0,
                    listOf("1863", "1875", "1888", "1899"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el hueso más largo del cuerpo humano?",
                    1,
                    listOf("Fémur", "Húmero", "Tibia", "Radio"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién formuló la teoría de la evolución química?",
                    3,
                    listOf("Charles Darwin", "Alfred Russel Wallace", "Louis Pasteur", "Alexander Oparin"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el río más largo de África?",
                    0,
                    listOf("Nilo", "Congo", "Zambeze", "Níger"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se produjo el Desastre de Chernóbil?",
                    1,
                    listOf("1982", "1986", "1990", "1994"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el periodo de rotación de Marte alrededor de su eje?",
                    1,
                    listOf("24 horas", "25 horas", "26 horas", "27 horas"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién descubrió la penicilina?",
                    0,
                    listOf("Alexander Fleming", "Louis Pasteur", "Joseph Lister", "Ernest Duchesne"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la isla más grande del mundo?",
                    0,
                    listOf("Groenlandia", "Borneo", "Madagascar", "Sri Lanka"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se celebró la primera Copa Mundial de la FIFA?",
                    1,
                    listOf("1928", "1930", "1934", "1938"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el quinto planeta del sistema solar?",
                    1,
                    listOf("Marte", "Júpiter", "Saturno", "Urano"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la ciudad más poblada de África?",
                    0,
                    listOf("Lagos", "El Cairo", "Kinshasa", "Yakarta"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la Revolución Industrial en Francia?",
                    2,
                    listOf("1750", "1789", "1800", "1825"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el compuesto químico del ácido sulfúrico?",
                    1,
                    listOf("HCl", "H2SO4", "HNO3", "HF"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién escribió 'Crimen y castigo'?",
                    0,
                    listOf("Fyodor Dostoevsky", "Leo Tolstoy", "Anton Chekhov", "Nikolai Gogol"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Noruega?",
                    0,
                    listOf("Oslo", "Estocolmo", "Copenhague", "Helsinki"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la independencia de Venezuela?",
                    1,
                    listOf("1800", "1810", "1821", "1830"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el proceso químico de la fotosíntesis inversa?",
                    1,
                    listOf("Fotosíntesis", "Quimiosíntesis", "Respiración celular", "Oxidación"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién fue el primer presidente de la República Popular China?",
                    1,
                    listOf("Sun Yat-sen", "Mao Zedong", "Chiang Kai-shek", "Deng Xiaoping"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el gas más abundante en la atmósfera de Marte?",
                    0,
                    listOf("Dióxido de carbono", "Nitrógeno", "Oxígeno", "Helio"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?",
                    1,
                    listOf("1942", "1945", "1950", "1955"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el hueso más pequeño del cuerpo humano?",
                    1,
                    listOf("Estribo", "Martillo", "Yunque", "Fémur"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el río más largo de Sudamérica?",
                    0,
                    listOf("Amazonas", "Orinoco", "Paraná", "Magdalena"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la independencia de Argentina?",
                    1,
                    listOf("1808", "1810", "1821", "1830"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el periodo orbital de la Luna alrededor de la Tierra?",
                    1,
                    listOf("25 días", "27.3 días", "31 días", "35 días"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién descubrió la estructura de doble hélice del ADN?",
                    2,
                    listOf("James Watson", "Francis Crick", "Rosalind Franklin", "Linus Pauling"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el metal más abundante en la corteza terrestre?",
                    0,
                    listOf("Aluminio", "Hierro", "Cobre", "Zinc"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la Revolución Rusa?",
                    1,
                    listOf("1915", "1917", "1920", "1923"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el metal más reactivo de la tabla periódica?",
                    0,
                    listOf("Francio", "Sodio", "Potasio", "Rubidio"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la Unión Europea?",
                    2,
                    listOf("1950", "1965", "1993", "1980"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el gas de efecto invernadero más abundante en la atmósfera terrestre?",
                    1,
                    listOf("Metano", "Dióxido de carbono", "Óxido nitroso", "Vapor de agua"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién fue la primera mujer en recibir un Premio Nobel?",
                    0,
                    listOf("Marie Curie", "Rosalind Franklin", "Dorothy Crowfoot Hodgkin", "Irene Joliot-Curie"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Australia?",
                    0,
                    listOf("Canberra", "Sídney", "Melbourne", "Brisbane"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la Revolución China?",
                    2,
                    listOf("1905", "1911", "1949", "1958"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la montaña más alta de África?",
                    1,
                    listOf("Monte Elbrús", "Monte Kilimanjaro", "Monte Everest", "Monte McKinley"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el periodo orbital de Mercurio alrededor del Sol?",
                    0,
                    listOf("88 días", "180 días", "365 días", "687 días"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la independencia de México?",
                    2,
                    listOf("1808", "1810", "1821", "1836"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el segundo elemento más abundante en la corteza terrestre?",
                    1,
                    listOf("Hierro", "Silicio", "Aluminio", "Calcio"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién fue el primer hombre en caminar sobre la Luna?",
                    0,
                    listOf("Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Alan Shepard"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la ciudad más poblada de Canadá?",
                    0,
                    listOf("Toronto", "Montreal", "Vancouver", "Calgary"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la ciudad de Roma?",
                    0,
                    listOf("753 a.C.", "500 a.C.", "200 a.C.", "100 d.C."),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién escribió 'Matar a un ruiseñor'?",
                    0,
                    listOf("Harper Lee", "J.K. Rowling", "George Orwell", "Ernest Hemingway"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Irán?",
                    0,
                    listOf("Teherán", "Bagdad", "Kabul", "Islamabad"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Entre qué años se llevó a cabo la Revolución Industrial en Inglaterra?",
                    2,
                    listOf("1700-1775", "1750-1800", "1760-1840", "1850-1890"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el océano más grande del mundo?",
                    1,
                    listOf("Océano Atlántico", "Océano Pacífico", "Océano Índico", "Océano Antártico"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el país más grande del mundo en términos de superficie terrestre?",
                    1,
                    listOf("China", "Rusia", "Estados Unidos", "Canadá"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la Organización de Estados Americanos (OEA)?",
                    2,
                    listOf("1945", "1950", "1948", "1955"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el elemento más abundante en el Sol?",
                    0,
                    listOf("Hidrógeno", "Helio", "Oxígeno", "Hierro"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién fue el fundador del psicoanálisis?",
                    0,
                    listOf("Sigmund Freud", "Carl Jung", "Ivan Pavlov", "B.F. Skinner"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Suecia?",
                    3,
                    listOf("Helsinki", "Copenhague", "Oslo", "Estocolmo"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la independencia de Chile?",
                    1,
                    listOf("1810", "1818", "1825", "1830"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la hormona responsable de regular el metabolismo?",
                    0,
                    listOf("Tiroxina", "Insulina", "Adrenalina", "Cortisol"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la velocidad de escape de la Tierra?",
                    0,
                    listOf("11 km/s", "7 km/s", "5 km/s", "9 km/s"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se fundó la Liga de las Naciones?",
                    1,
                    listOf("1918", "1920", "1925", "1930"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién formuló la teoría de la relatividad especial?",
                    3,
                    listOf("Isaac Newton", "Max Planck", "Niels Bohr", "Albert Einstein"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el río más largo de América del Sur?",
                    0,
                    listOf("Amazonas", "Orinoco", "Paraná", "Magdalena"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la independencia de Perú?",
                    1,
                    listOf("1808", "1821", "1830", "1845"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la distancia promedio de la Tierra al Sol?",
                    0,
                    listOf("150 millones de km", "100 millones de km", "200 millones de km", "250 millones de km"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Quién fue el pintor impresionista francés más destacado?",
                    0,
                    listOf("Claude Monet", "Pierre-Auguste Renoir", "Edgar Degas", "Camille Pissarro"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es la capital de Turquía?",
                    0,
                    listOf("Ankara", "Estambul", "Izmir", "Bursa"),
                    "Hard"
                ),
                QTextEntity(
                    "¿En qué año se llevó a cabo la Revolución Cubana?",
                    1,
                    listOf("1950", "1959", "1965", "1970"),
                    "Hard"
                ),
                QTextEntity(
                    "¿Cuál es el componente principal del sistema nervioso central?",
                    1,
                    listOf("Neuronas", "Encéfalo", "Dendritas", "Axones"),
                    "Hard"
                )
            )
            withContext(Dispatchers.IO) {
                Log.d("DB", "INSERT Q_TEXTs")
                qTextDao.insertQTexts(textQuestions)
                Log.d("DB", "Q_TEXTs INSERTED")
            }
        }
        private suspend fun insertInitialImagesQuestions(qImageDao: QImageDao) {
            val imageQuestions = listOf(
                QImageEntity(
                    "¿Cuál es una célula animal?",
                    2,
                    listOf(
                        R.drawable.plantcell,
                        R.drawable.virus,
                        R.drawable.cell,
                        R.drawable.bacteria
                    ),
                    "Science"
                ),
                QImageEntity(
                    "¿Cuál es un planeta del sistema solar?",
                    0,
                    listOf(R.drawable.saturn, R.drawable.moon, R.drawable.milkyway, R.drawable.sun),
                    "Science"
                ),
                QImageEntity(
                    "¿Cuál es un fenómeno de reflexión de la luz?",
                    1,
                    listOf(
                        R.drawable.gravity,
                        R.drawable.rainbow,
                        R.drawable.magnet,
                        R.drawable.rain
                    ),
                    "Science"
                ),
                QImageEntity(
                    "¿Cuál es ADN?",
                    3,
                    listOf(
                        R.drawable.mitochondria,
                        R.drawable.rna,
                        R.drawable.virus,
                        R.drawable.dna
                    ),
                    "Science"
                ),
                QImageEntity(
                    "¿Cuál es Ares, dios de la guerra griego?",
                    0,
                    listOf(
                        R.drawable.ares,
                        R.drawable.zeus,
                        R.drawable.poseidon,
                        R.drawable.atenea
                    ),
                    "History"
                ),
                QImageEntity(
                    "¿Cuál es Zeus, dios del rayo griego?",
                    1,
                    listOf(
                        R.drawable.poseidon,
                        R.drawable.zeus,
                        R.drawable.ares,
                        R.drawable.atenea
                    ),
                    "History"
                ),
                QImageEntity(
                    "¿Cuál escritura cuneiforme?",
                    2,
                    listOf(
                        R.drawable.pergamino,
                        R.drawable.japones,
                        R.drawable.cuneiforme,
                        R.drawable.jeroglifico
                    ),
                    "History"
                ),
                QImageEntity(
                    "¿Cuál escritura japonesa?",
                    3,
                    listOf(
                        R.drawable.cuneiforme,
                        R.drawable.jeroglifico,
                        R.drawable.pergamino,
                        R.drawable.japones
                    ),
                    "History"
                ),
                QImageEntity(
                    "¿Cuál es un campo de fútbol?",
                    0,
                    listOf(
                        R.drawable.football_field,
                        R.drawable.baseball_field,
                        R.drawable.golf_field,
                        R.drawable.basket_field
                    ),
                    "Sports"
                ),
                QImageEntity(
                    "¿Cuál es un campo de baseball?",
                    1,
                    listOf(
                        R.drawable.golf_field,
                        R.drawable.baseball_field,
                        R.drawable.basket_field,
                        R.drawable.football_field
                    ),
                    "Sports"
                ),
                QImageEntity(
                    "¿Cuál es un campo de baseball?",
                    1,
                    listOf(
                        R.drawable.golf_field,
                        R.drawable.baseball_field,
                        R.drawable.basket_field,
                        R.drawable.football_field
                    ),
                    "Sports"
                ),
                QImageEntity(
                    "¿En que equipo estan o estuvieron Messi y Levandowski?",
                    2,
                    listOf(
                        R.drawable.manchester_united,
                        R.drawable.liverpool,
                        R.drawable.barcelona,
                        R.drawable.real_madrid
                    ),
                    "Sports"
                ),
                QImageEntity(
                    "¿Cuál fue el ultimo equipo de Cristiano Ronaldo en Europa?",
                    3,
                    listOf(
                        R.drawable.liverpool,
                        R.drawable.barcelona,
                        R.drawable.real_madrid,
                        R.drawable.manchester_united
                    ),
                    "Sports"
                ),
                QImageEntity(
                    "¿Qué forma tenia la famosa TARDIS de Doctor Who?",
                    2,
                    listOf(
                        R.drawable.telephone_box,
                        R.drawable.telephone_box2,
                        R.drawable.tardis,
                        R.drawable.telephone_box1
                    ),
                    "Series"
                ),
                QImageEntity(
                    "¿Qué necesita un mago para conjurar?",
                    3,
                    listOf(
                        R.drawable.caldera,
                        R.drawable.escoba,
                        R.drawable.serpiente,
                        R.drawable.varita
                    ),
                    "Series"
                )
            )
            withContext(Dispatchers.IO) {
                Log.d("DB", "INSERT Q_IMAGES")
                qImageDao.insertQImages(imageQuestions)
                Log.d("DB", "Q_IMAGES INSERTED")
            }
        }
        private suspend fun insertInitialFromImagesQuestions(qFromImageDao: QFromImageDao) {
            val fromImageQuestions = listOf(
                QFromImageEntity(
                    "¿Qué nombre recibe esta molécula?",
                    R.drawable.h2o,
                    3,
                    listOf(
                        "Monóxido de hidrógeno",
                        "Cloruro de sodio",
                        "Dihidrógeno de oxígeno",
                        "Monóxido de dihidrógeno"
                    ),
                    "Science"
                ),
                QFromImageEntity(
                    "¿Qué elemento produce fuego de este color?",
                    R.drawable.flame,
                    2,
                    listOf("Cloro", "Sodio", "Cobre", "Radón"),
                    "Science"
                ),
                QFromImageEntity(
                    "¿Qué celebre científico desarrollo la formula?",
                    R.drawable.einstein_form,
                    1,
                    listOf("Issac Newton", "Albert Einstein", "Nicola Tesla", "Michael Faraday"),
                    "Science"
                ),
                QFromImageEntity(
                    "¿Qué planeta es?",
                    R.drawable.jupiter,
                    0,
                    listOf("Jupiter", "Urano", "Venus", "Plutón"),
                    "Science"
                ),
                QFromImageEntity(
                    "¿Qué animal es?",
                    R.drawable.leopard,
                    3,
                    listOf("Pantera", "León", "Tigre", "Leopardo"),
                    "Science"
                ),
                QFromImageEntity(
                    "¿Qué civilizacion le pertenece este simbolo?",
                    R.drawable.spqr,
                    0,
                    listOf("Imperio Romano", "Imperio Otomano", "Imperio Ruso", "Griegos"),
                    "History"
                ),
                QFromImageEntity(
                    "¿De donde era origen esta figura gobernante?",
                    R.drawable.pharaoh,
                    1,
                    listOf("Grecia", "Egipto", "Arabia", "Nórdicos"),
                    "History"
                ),
                QFromImageEntity(
                    "¿Qué personajes historicos se salvaron por ese animal?",
                    R.drawable.wolf,
                    2,
                    listOf("Nickolas II", "Julio César", "Rómulo y Remo", "Isabel II"),
                    "History"
                ),
                QFromImageEntity(
                    "¿De dónde son originarios estos guerreros?",
                    R.drawable.samurai,
                    3,
                    listOf("China", "Suecia", "México", "Japón"),
                    "History"
                ),
                QFromImageEntity(
                    "¿De quién es esta celebre pintura?",
                    R.drawable.monalisa,
                    1,
                    listOf("Miguél Ángel", "Leonardo da Vinci", "Piccasso", "Joan Miró"),
                    "History"
                ),
                QFromImageEntity(
                    "¿Como se llama al área más pequeña en este deporte?",
                    R.drawable.golf,
                    0,
                    listOf("Green", "Lie", "Swing", "Putt"),
                    "Sports"
                ),
                QFromImageEntity(
                    "¿Cuál es la capacidad máxima de estos campos?",
                    R.drawable.football_field,
                    1,
                    listOf("100x120m", "90x120m", "70x120m", "90x160m"),
                    "Sports"
                ),
                QFromImageEntity(
                    "¿Qué deporte usa este balón?",
                    R.drawable.american_football,
                    2,
                    listOf("Baseball", "Tenis", "Fútbol americano", "Baloncesto"),
                    "Sports"
                ),
                QFromImageEntity(
                    "¿Qué deporte representa este símbolo?",
                    R.drawable.chess,
                    3,
                    listOf("Monopoly", "Ping-pong", "Damas", "Ajedrez"),
                    "Sports"
                ),
                QFromImageEntity(
                    "¿Qué deporte es?",
                    R.drawable.ping_pong,
                    0,
                    listOf("Tenis de mesa", "Tenis", "Boxeo", "Kick-Boxing"),
                    "Sports"
                ),
                QFromImageEntity(
                    "¿Qué serie coreana se hizo famosa con este símbolo?",
                    R.drawable.squid,
                    0,
                    listOf(
                        "El juego del calamar",
                        "Ley y orden",
                        "Arriba de todos",
                        "El jade azul"
                    ),
                    "Series"
                ),
                QFromImageEntity(
                    "¿Qué serie trata sobre un ladrón famoso?",
                    R.drawable.criminal,
                    0,
                    listOf("Lupin", "Juego de tronos", "El juego del calamar", "Naruto"),
                    "Series"
                )
            )
            withContext(Dispatchers.IO) {
                Log.d("DB", "INSERT Q_FROM_IMAGES")
                qFromImageDao.insertQFromImages(fromImageQuestions)
                Log.d("DB", "Q_FROM_IMAGES INSERTED")
            }
        }
        private suspend fun insertInitialData(
            instance: AppDatabase
        ) {
            Log.d("DB", "GENERATE INITDATA INIT")
            insertsInitialPlayers(instance.playerDao())
            insertInitialTextQuestions(instance.qTextDao())
            insertInitialImagesQuestions(instance.qImageDao())
            insertInitialFromImagesQuestions(instance.qFromImageDao())
            Log.d("DB", "GENERATE INITDATA END")
        }
    }
}