package xyz.thehiddenobject.thochat.common.infrastructure.persistence.ormlite

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.support.ConnectionSource
import kotlin.reflect.KClass

open class OrmLiteCrudRepository<T : Any, ID>(
    connectionSource: ConnectionSource,
    clazz: KClass<T>
) {
    private val dao: Dao<T, ID> =
        DaoManager.createDao(connectionSource, clazz.java)

    fun create(entity: T) = dao.create(entity)
    fun update(entity: T) = dao.update(entity)
    fun findById(id: ID): T? = dao.queryForId(id)
    fun deleteById(id: ID) = dao.deleteById(id)
}