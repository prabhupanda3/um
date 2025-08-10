package com.fmt.Umd.Dashboard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.Dashboard.Model.Daysummary;
import com.fmt.Umd.Dashboard.Projection.CommSummaryProjection;

@Repository
public interface DaySummaryRepository extends JpaRepository<Daysummary, Integer>{
@Query(value="select d.comm_date AS commDate,sum(d.comm) as totalComm "+
         "from daysummary d"+" where d.comm_date in(:dates) and d.discom=:discom "+"Group by d.comm_date order by d.comm_date desc",nativeQuery = true)
List<CommSummaryProjection> findLastSevenDaysCommunicationBYDiscom(@Param("dates") List<String> dates,@Param("discom")String discom);
@Query(value="select d.comm_date AS commDate,sum(d.comm) as totalComm "+
        "from daysummary d"+" where d.comm_date in(:dates) and d.circle=:circle "+"Group by d.comm_date order by d.comm_date desc",nativeQuery = true)
List<CommSummaryProjection> findLastSevenDaysCommunicationByCircle(@Param("dates") List<String> dates,@Param("circle")String circle);

@Query(value="select d.comm_date AS commDate,sum(d.comm) as totalComm "+
        "from daysummary d"+" where d.comm_date in(:dates) and d.division=:division "+"Group by d.comm_date order by d.comm_date desc",nativeQuery = true)
List<CommSummaryProjection> findLastSevenDaysCommunicationByDivision(@Param("dates") List<String> dates,@Param("division")String division);

@Query(value="select d.comm_date AS commDate,sum(d.comm) as totalComm "+
        "from daysummary d"+" where d.comm_date in(:dates) and d.sdo=:sdo "+"Group by d.comm_date order by d.comm_date desc",nativeQuery = true)
List<CommSummaryProjection> findLastSevenDaysCommunicationBySdo(@Param("dates") List<String> dates,@Param("sdo")String sdo);

}
