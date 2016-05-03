package id.posyandu.service;

import id.posyandu.domain.Jabatan;
import java.util.Collection;

public interface JabatanService {
    public Jabatan saveJabatan(Jabatan jabatan);

    public Boolean deleteJabatan(String jabatanId);

    public Jabatan editJabatan(Jabatan jabatan);

    public Jabatan findJabatan(String jabatanId);

    public Collection<Jabatan> getAllJabatans();
}
