import android.content.Context
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.advnative_waroengujang.model.WaroengUjangDatabase

val DB_NAME = "ujangdb"

fun buildDB(context: Context):WaroengUjangDatabase {
    val db = databaseBuilder(context, WaroengUjangDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2)
        .build()
    return db
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE todo ADD COLUMN priority INTEGER DEFAULT 3 not null")
    }
}
