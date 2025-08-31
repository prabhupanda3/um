package com.fmt.Umd.Dashboard.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fmt.Umd.Dashboard.Projection.DeviceDiagnosisSummaryProjection;
import com.fmt.Umd.model.DeviceDiagnosisSummary;

@Repository
public interface DeviceDiagnosisSummaryRepository extends JpaRepository<DeviceDiagnosisSummary, Long>{
	@Query("select d.meterSerialNo as meterSerialNo, " +
		       "d.modemSerialNo as modemSerialNo, " +
		       "d.gsmSignal as gsmSignal " +
		       "from DeviceDiagnosisSummary d " +
		       "where d.meterSerialNo in (:meterSlNoList) " +
		       "and d.diagTimestamp like concat(:diagTimestamp, '%')")
		List<DeviceDiagnosisSummaryProjection> getModemSlNumberAndgsmSignal(
		        @Param("meterSlNoList") List<String> meterSlNoList,
		        @Param("diagTimestamp") String diagTimestamp);



}
