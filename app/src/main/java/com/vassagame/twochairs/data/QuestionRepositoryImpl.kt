package com.vassagame.twochairs.data

import android.content.Context
import com.vassagame.twochairs.data.db.AppDatabase
import com.vassagame.twochairs.data.db.mapper.PackMapper
import com.vassagame.twochairs.domain.entity.dbentity.PackDomEntity
import com.vassagame.twochairs.domain.entity.dbentity.QuestionDomEntity
import com.vassagame.twochairs.domain.reposytory.QuestionRepository

class QuestionRepositoryImpl(val context: Context, val db: AppDatabase) : QuestionRepository {
    var array: ArrayList<String> = ArrayList()
    //var useCase: OpenDataBaseUseCase


    init {
//        //useCase = OpenDataBaseUseCase(context, "questionDB.db")
//        array.add("Ким ви хотіли стати, коли були дитиною?")
//        array.add("Ви рахуэте себе розумним? Чому?")
//        array.add("Якби була можливість спитати в Бога і отримати відповідь, щоб спитали?")
//        array.add("Яка твоя перша робота за яку ти отримав перший прибуток(в грошах)?")
//        array.add("Чи є щось, що ви ніколи не пробачите близькій людині?")
//        array.add("[player], взяв(ла) вашу дорогоціну річ і не вернула. Ваші дії.")
//        array.add("Ранком ви просинаєтесь і виявили що разом з вами спав [player]. Ваші перші думки?")
//        array.add("Ви знаєте чуму вам дали саме це імя? Чуму так?")
//        array.add("Формула Піфагора?")
//        array.add("Гуманітарій чи Технарь? Чому такий вибір?")
//        array.add("Якщо б ви могли просто зараз без проблем переїхати в інше місто чи країну, куди б переїхали? Чому?")
//        array.add("Три самі яскравих момента вашого життя?")
//        array.add("Три сами пічальних момента вашого життя?")
//        array.add("[player] пропонує переспати ваші дії?")
//        array.add("У вас є хобі? Розкажіть про нього?")
//        array.add("Чи важаєте ви себе доброю людиною? Чому?")
//        array.add("[player] забув(ла) забарати вас з вокзалу? Ваші дії?")
//        array.add("Розкажіть про найгірший день життя?")
//        array.add("Три слова про [player]?")
//        array.add("Чи є щось, що ви ніколи не пробачите близькій людині?")
//        array.add("Де ви навчалися після школи? Це був ваш свідомий вибір?")
//        array.add("Гроші рашають? Якщо ні то шо?")
//        array.add("Ситуація - страшно холодно, ви відчуваєте що замерзаєте, [player] пропонує вам обнятись щоб зігрітись. ви б на це пішли? Чому?")
//        array.add("Ситуація вас запросили на день народження разом з [player]. [player] сильно перебрав і намагається зробити річ за яку йому буду стидно все життя(на вашу думку). Ви попробуєте зупинити його? Чому?")
//        array.add("Вам подобалось ходити у школу? На які оцінки ви навчались і які предмети вам подобались найбільше?")
//        array.add("Сама прікольна подія в школі, яка була з вами?")
//        array.add("У вас є можливість попасти в минуле, на яку подію ви б хотіл попасти? Чому?")
//        array.add("У вас є можливість попасти в минуле, на кого з присутніх ви б попробували повпливати?")
//        array.add("У вас є можливість попасти в минуле, за чиїм життям з присутніх ви б понаблюдали?")
    }

    override suspend fun getPackAll(): ArrayList<PackDomEntity> {
        val listData = db.packDao().getPackAll()
        return PackMapper.packArrayDataToDomain(listData)//.test2(listData)
    }

    override suspend fun addNewPack(pack: PackDomEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun removePack(packName: String) {
        val listData = db.packDao().getPackAll()
        TODO("Not yet implemented")
    }

    override suspend fun getQuestionAll(): ArrayList<QuestionDomEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun addNewQuestion(pack: PackDomEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun removeQuestion(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun test() {
        TODO("Not yet implemented")
    }


}