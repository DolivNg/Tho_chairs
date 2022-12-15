package com.vassagame.twochairs.data.db.mapper

import com.vassagame.twochairs.data.db.entity.PackEntity
import com.vassagame.twochairs.data.db.entity.PackFull
import com.vassagame.twochairs.domain.entity.dbentity.PackDomEntity
import com.vassagame.twochairs.domain.entity.dbentity.QuestionDomEntity

class PackMapper {
     companion object {

         private fun packDataToDomain(packData: PackEntity): PackDomEntity {
             return PackDomEntity(
                 id = packData.id,
                 packName = packData.packName,
                 standard = packData.standard,
                 selected = packData.selected,

             )
         }

         fun packArrayDataToDomain(packArrayData: List<PackEntity>): List<PackDomEntity> {
             val array = ArrayList<PackDomEntity>()
             packArrayData.forEach {
                 array.add(
                     packDataToDomain(it)
                 )
             }
             return array
         }

         private fun packDomainToData(packDomain: PackDomEntity): PackEntity {
             return PackEntity(
                 id = packDomain.id,
                 packName = packDomain.packName,
                 standard = packDomain.standard,
                 selected = packDomain.selected
             )
         }

         fun packArrayDomainToData(packArrayDomain: List<PackDomEntity>): List<PackEntity> {
             val array = ArrayList<PackEntity>()
             packArrayDomain.forEach {
                 array.add(
                     packDomainToData(it)
                 )
             }
             return array
         }
     }


}