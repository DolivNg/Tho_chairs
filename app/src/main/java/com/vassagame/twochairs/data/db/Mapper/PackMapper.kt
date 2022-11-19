package com.vassagame.twochairs.data.db.Mapper

import com.vassagame.twochairs.data.db.entity.PackEntity
import com.vassagame.twochairs.domain.entity.dbentity.PackDomEntity

 class PackMapper {
     companion object {
         fun packDataToDomain(packData: PackEntity): PackDomEntity {
             return PackDomEntity(
                 id = packData.id,
                 packName = packData.packName,
                 standard = packData.standard,
                 selected = packData.selected
             )
         }

         fun packArrayDataToDomain(packArrayData: ArrayList<PackEntity>): ArrayList<PackDomEntity> {
             val array = ArrayList<PackDomEntity>()
             packArrayData.forEach {
                 array.add(
                     packDataToDomain(it)
                 )
             }
             return array
         }

         fun packDomainToData(packDomain: PackDomEntity): PackEntity {
             return PackEntity(
                 id = packDomain.id,
                 packName = packDomain.packName,
                 standard = packDomain.standard,
                 selected = packDomain.selected
             )
         }

         fun packArrayDomainToData(packArrayDomain: ArrayList<PackDomEntity>): ArrayList<PackEntity> {
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