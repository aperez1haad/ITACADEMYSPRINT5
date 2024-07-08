package cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n03.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FlorEntityDTO {
    private int pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;
}
