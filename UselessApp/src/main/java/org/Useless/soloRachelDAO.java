package org.Useless;

import java.util.List;

public interface soloRachelDAO {
    boolean novoSolo (soloRachel solo);
    List<soloRachel> listar();
    boolean alterarSolo(soloRachel solo);
    boolean apagarSolo(soloRachel solo);
}
