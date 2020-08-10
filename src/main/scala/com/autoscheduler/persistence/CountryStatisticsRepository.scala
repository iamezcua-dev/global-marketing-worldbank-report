package com.autoscheduler.persistence

import com.autoscheduler.model.Information
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait CountryStatisticsRepository extends CrudRepository[ Information, Integer ]

