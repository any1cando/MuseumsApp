package com.panevrn.museumsapp

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panevrn.museumsapp.databinding.ActivityMainBinding

class MuseumsActivity : AppCompatActivity(), MuseumAdapter.OnItemClickListener{
    private lateinit var adapter: MuseumAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museums)

        recyclerView = findViewById(R.id.rcView)


        val listMuseums: ArrayList<Museum> = arrayListOf()
        val mus1: Museum = Museum(
            0,
            "Государственный Эрмитаж",
            "Крупнейший в России и один из крупнейших в мире художественных и культурно-исторических музеев. Возник в 1764 году как частное собрание Екатерины II. Музей был открыт для посещения в 1852 году в специально построенном для этой цели здании Нового Эрмитажа.",
            "8 (999) 777 50-40",
            "https://www.tripadvisor.ru/Attraction_Review-g298507-d300071-Reviews-The_State_Hermitage_Museum-St_Petersburg_Northwestern_District.html",
            "Дворцовая наб., д. 30-38, Санкт-Петербург 191055 Россия",
            R.drawable.ermitage
        )
        val mus2: Museum = Museum(
            0,
            "Большой Петергофский дворец",
            "Большо́й дворе́ц — основное здание дворцово-паркового ансамбля «Петергоф», расположенного в одноимённом городе на южном берегу Финского залива в Петродворцовом районе города федерального значения Санкт-Петербурга. Был практически полностью разрушен во время Второй мировой войны, в 1952 году восстановлен.",
            "8 (889) 545 23-10",
            "https://www.tripadvisor.ru/Attraction_Review-g1207894-d300086-Reviews-Grand_Peterhof_Palace-Peterhof_Petrodvortsovy_District_St_Petersburg_Northwestern.html",
            "ул. Разводная, д. 2, Петергоф, Санкт-Петербург 198516 Россия",
            R.drawable.peterghofskiy_palace
        )
        val mus3: Museum = Museum(
            0,
            "Казанский Кремль",
            "Каза́нский кремль — древнейшая часть и цитадель Казани, комплекс архитектурных, исторических и археологических памятников, раскрывающих многовековую историю города: археологические остатки первого, второго и третьего городищ, собственно белокаменный кремль, ряд храмов и зданий, имеющих большую историко-архитектурную знать.",
            "8 (843) 567-81-42",
            "https://www.tripadvisor.ru/Attraction_Review-g298520-d321110-Reviews-Kazan_Kremlin-Kazan_Republic_of_Tatarstan_Volga_District.html",
            "Улмца Проводники, д. 15, Роскошь, Казань",
            R.drawable.kazan_kremle
        )
        val mus4: Museum = Museum(
            0,
            "Музейный комплекс \"Государственный музей-памятник \"",
            "Музей-памятник \"Исаакиевский собор\" - один из наиболее значительных художественных музеев России, пользующийся известностью во многих зарубежных странах.\n" +
                    "    Исаакиевский собор - уникальный памятник отечественной архитектуры и один из лучших кафедральных соборов Европы. Это выдающийся образец русского культового искусства.\n" +
                    "\n" +
                    "    Художественное оформление собора включает крупнейшее собрание русской монументальной живописи середины XIX века, насчитывающее более 150 произведений.",
            "8 (432) 123-40-32",
            "https://www.tripadvisor.ru/Attraction_Review-g298507-d300132-Reviews-The_State_Museum_St_Isaac_s_Cathedral-St_Petersburg_Northwestern_District.html",
            "Исаакиевская площадь, 4 м. Невский проспект, Санкт-Петербург 190000 Россия",
            R.drawable.gos_caption_4
        )
        val mus5: Museum = Museum(
            0,
            "Екатерининский дворец и парк",
            "Наряду с дворцовым комплексом неотъемлемой частью Царскосельской императорской резиденции являются парки, прежде всего главные из них — Екатерининский и Александровский, получившие эти названия по находящимся в них дворцам.\n" +
                    "\n" +
                    "Екатерининский парк состоит из двух частей: регулярного Старого сада и пейзажного Английского парка. Старый (Голландский) сад основал, по преданию, сам Петр I. Эту легенду приводит в своем сочинении «Достопамятности Санкт-Петербурга и его окрестностей» (1817) П. П. Свиньин: «Петр I, заезжая иногда сюда прохлаждаться молоком к старой голландке Сарре, пленился местом сим…» и собственноручно насадил платановые и дубовые аллеи.",
            "8 (950) 434 34-12",
            "https://www.tripadvisor.ru/Attraction_Review-g811323-d301025-Reviews-Catherine_Palace_and_Park-Pushkin_Pushkinsky_District_St_Petersburg_Northwestern_D.html",
            "Садовая ул., д. 7 Царское Село, Пушкин, Санкт-Петербург 196601 Россия",
            R.drawable.ekaterina_palace
        )
        val mus6: Museum = Museum(
            0,
            "Государственная Третьяковская Галерея",
            "Российский государственный художественный музей в Москве, созданный на основе исторических коллекций купцов братьев Павла и Сергея Михайловичей Третьяковых; одно из крупнейших в мире собраний русского изобразительного искусства.",
            "8 (434) 290 43-89",
            "https://www.tripadvisor.ru/Attraction_Review-g298484-d300237-Reviews-State_Tretyakov_Gallery-Moscow_Central_Russia.html",
            "Лаврушинский переулок, д. 10, Москва 119017 Россия",
            R.drawable.tretyakov_gallery
        )
        val mus7: Museum = Museum(
            0,
            "Царицыно Музей-Заповедник",
            "Государственный музей декоративно-прикладного искусства народов СССР (ГМДПИ) под руководством художника Ильи Глазунова. В начале 1992 года комплекс переименовали в Государственный историко-архитектурный, художественный и ландшафтный музей-заповедник «Царицыно», а вскоре после этого московскому району Ленино вернули историческое название Царицыно.",
            "8 (545) 434 23-12",
            "https://www.tripadvisor.ru/Attraction_Review-g298484-d524791-Reviews-Tsaritsyno_Museum_Reserve-Moscow_Central_Russia.html",
            "Дольская улица, д. 1, Москва 115569 Россия",
            R.drawable.caricino_museum
        )
        val mus8: Museum = Museum(
            0,
            "Московский Кремль",
            "Крепость в центре Москвы и древнейшая её часть, главный общественно-политический и историко-художественный комплекс города, официальная резиденция Президента Российской Федерации, вплоть до распада СССР в декабре 1991 года была официальной резиденцией Генерального секретаря ЦК КПСС.",
            "8 (985) 082 34-12",
            "https://www.tripadvisor.ru/Attraction_Review-g298484-d300392-Reviews-Moscow_Kremlin-Moscow_Central_Russia.html",
            "Район/квартал: Тверской",
            R.drawable.moscow_kremle
        )
        val mus9: Museum = Museum(
            0,
            "Гранд Макет Россия",
            "Национальный шоу-музей в Санкт-Петербурге. Представляет собой макет, выполненный в масштабе 1:87, площадью 800 м², где объединены собирательные образы регионов Российской Федерации. Является самым большим макетом в России и вторым по величине в мире.",
            "8 (985) 232 43-33",
            "https://www.tripadvisor.ru/Attraction_Review-g298507-d3396387-Reviews-Grand_Maket_Russia-St_Petersburg_Northwestern_District.html",
            "ул. Цветочная, 16, Санкт-Петербург 196084 Россия",
            R.drawable.grand_maket
        )
        val mus10: Museum = Museum(
            0,
            "Оружейная палата",
            "Московский музей-сокровищница, являющийся частью комплекса Большого Кремлёвского дворца. Учреждение названо в честь государственного казнохранилища, в состав которого в 1720 году вошли кремлёвские мастерские.",
            "8 (444) 232 40-98",
            "https://www.tripadvisor.ru/Attraction_Review-g298484-d300396-Reviews-Armoury_Chamber-Moscow_Central_Russia.html",
            "ул. Дворцовая, д. 1р, Москва 103073 Россия",
            R.drawable.weapon_palata
        )
        val mus11: Museum = Museum(
            0,
            "Московский Государственный Объединенный Музей-Заповедник \"Коломенское\"",
            "Мы будем рады, если вы поделитесь своим опытом посещения выставок, экскурсий или парковых территорий. Также вы можете задать любые интересующие вопросы. Ответ на обращение поступит на вашу электронную почту в течение суток.",
            "8 (212) 323-23-34",
            "https://www.tripadvisor.ru/Attraction_Review-g298484-d300345-Reviews-Kolomenskoye_Historical_and_Architectural_Museum_and_Reserve-Moscow_Central_Russia.html",
            "Андропова проспект, 39, Москва 115487 Россия",
            R.drawable.zapovednik_kolomenskoe
        )
        val mus12: Museum = Museum(
            0,
            "Музей Фаберже",
            "Музей Фаберже в Санкт-Петербурге создан для сохранения, изучения и популяризации культурного наследия России, а также для развития музейной инфраструктуры города. Основу собрания музея составляет крупнейшая в мире коллекция произведений фирмы Карла Фаберже, включающая в себя девять знаменитых императорских пасхальных яиц. Они обладают огромной ценностью не только как предметы высочайшего ювелирного мастерства, но и как уникальные исторические артефакты.",
            "8 (990) 434 12-55",
            "https://www.tripadvisor.ru/Attraction_Review-g298507-d6580510-Reviews-Faberge_Museum-St_Petersburg_Northwestern_District.html",
            "Набережная реки Фонтанки, 21 Шуваловский дворец, Санкт-Петербург 191011 Россия",
            R.drawable.phaberzhe_museum
        )
        val mus13: Museum = Museum(
            0,
            "Государственный Русский музей",
            "Российский государственный художественный музей в Санкт-Петербурге, крупнейшее в мире собрание русского изобразительного искусства.",
            "8 (323) 121 23-11",
            "https://www.tripadvisor.ru/Attraction_Review-g298507-d301191-Reviews-State_Russian_Museum-St_Petersburg_Northwestern_District.html",
            "ул. Инженерная, д. 4 м. Гостиный двор, Невский проспект, Санкт-Петербург 191011 Россия",
            R.drawable.gos_russian_museum
        )
        val mus14: Museum = Museum(
            0,
            "Тульский Государственный Музей Оружия",
            "Тульский государственный музей оружия — один из старейших и крупнейший музей оружия в России, одна из главных достопримечательностей Тулы. Входит в десятку крупнейших музеев Европы.",
            "8 (323) 444 32-11",
            "https://www.tripadvisor.ru/Attraction_Review-g298486-d2572123-Reviews-Tula_State_Museum_of_Weapons-Tula_Tula_Oblast_Central_Russia.html",
            "ул. Октябрьская, 2, Тула 300026 Россия",
            R.drawable.tulskiy_weapon_museum
        )
        val mus15: Museum = Museum(
            0,
            "Казанский кафедральный собор",
            "Один из крупнейших храмов Санкт-Петербурга. Построен на Невском проспекте в 1801—1811 годах архитектором Андреем Воронихиным в стиле русского классицизма для хранения чтимого списка чудотворной иконы Божией Матери Казанской. ",
            "8 (111) 434 43-66",
            "https://www.tripadvisor.ru/Attraction_Review-g298507-d302000-Reviews-Kazan_Cathedral-St_Petersburg_Northwestern_District.html",
            "Казанская площадь, д. 2 м. Невский проспект, Санкт-Петербург 191186 Россия",
            R.drawable.kazan_sobor_weapon
        )

        dbHelper = DBHelper(this)
//        dbHelper.addMuseum(mus1)
//        dbHelper.addMuseum(mus2)
//        dbHelper.addMuseum(mus3)
//        dbHelper.addMuseum(mus4)
//        dbHelper.addMuseum(mus5)
//        dbHelper.addMuseum(mus6)
//        dbHelper.addMuseum(mus7)
//        dbHelper.addMuseum(mus8)
//        dbHelper.addMuseum(mus9)
//        dbHelper.addMuseum(mus10)
//        dbHelper.addMuseum(mus11)
//        dbHelper.addMuseum(mus12)
//        dbHelper.addMuseum(mus13)
//        dbHelper.addMuseum(mus14)
//        dbHelper.addMuseum(mus15)

        val museumsList = dbHelper.getAllMuseums()
        adapter = MuseumAdapter(museumsList, this)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(museum: Museum) {
        val intent = Intent(this, MuseumActivity::class.java)
        intent.putExtra("id", museum.id)
        startActivity(intent)
    }
}

//    private fun init() {
//        val recycleView = findViewById<RecyclerView>(R.id.rcView)
//        recycleView.layoutManager = LinearLayoutManager(this@MuseumsActivity)
//        recycleView.adapter = adapter
//
////        binding.apply {
////            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
////            rcView.adapter = adapter
////        }
//    }