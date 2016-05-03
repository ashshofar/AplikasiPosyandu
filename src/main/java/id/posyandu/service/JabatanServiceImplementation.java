package id.posyandu.service;

import id.posyandu.domain.Jabatan;
import id.posyandu.repositories.JabatanRepository;
import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JabatanServiceImplementation implements JabatanService {

    @Autowired
    protected JabatanRepository jabatanRepository;

    @Override
    public Jabatan saveJabatan(Jabatan jabatan) {
        return jabatanRepository.save(jabatan);
    }

    @Override
    public Boolean deleteJabatan(String jabatanId) {
        Jabatan temp = jabatanRepository.findOne(jabatanId);
        if (temp != null) {
            jabatanRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public Jabatan editJabatan(Jabatan jabatan) {
        return jabatanRepository.save(jabatan);
    }

    @Override
    public Jabatan findJabatan(String jabatanId) {
        return this.jabatanRepository.findOne(jabatanId);
    }

    @Override
    public Collection<Jabatan> getAllJabatans() {
        Iterable<Jabatan> itr = jabatanRepository.findAll();
        return (Collection<Jabatan>) itr;
    }

}
