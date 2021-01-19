package br.com.festivalNativista.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;
import java.security.MessageDigest;

@Getter
@Setter
@Entity
@Table(name = "login")
public class Login {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @NotEmpty
        @Column(name = "codigo")
        private String codigo;

        @NotNull @NotEmpty
        @Column(name = "senha")
        private String senha;

        public Login () {
            super();
        }

        public String codificar(String senha) {
                try {
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
                        return hash.toString(16);
                } catch (Exception e) {
                        return "";
                }
        }

}
