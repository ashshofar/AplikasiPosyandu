package id.posyandu.repositories;

import id.posyandu.domain.Jabatan;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface JabatanRepository extends CrudRepository<Jabatan, String>{
    
}
