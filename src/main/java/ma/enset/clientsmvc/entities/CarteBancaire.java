package ma.enset.clientsmvc.entities;

import java.time.LocalDate;

public class CarteBancaire {
        private String numeroCB;
        private LocalDate dateExpiration;
        private String titulaire;

        // Constructeur
        public CarteBancaire(String numeroCB, LocalDate dateExpiration, String titulaire) {
            this.numeroCB = numeroCB;
            this.dateExpiration = dateExpiration;
            this.titulaire = titulaire;
        }

        // Getters et setters
        public String getNumeroCB() {
            return numeroCB;
        }

        public void setNumeroCB(String numeroCB) {
            this.numeroCB = numeroCB;
        }

        public LocalDate getDateExpiration() {
            return dateExpiration;
        }

        public void setDateExpiration(LocalDate dateExpiration) {
            this.dateExpiration = dateExpiration;
        }

        public String getTitulaire() {
            return titulaire;
        }

        public void setTitulaire(String titulaire) {
            this.titulaire = titulaire;
        }

        @Override
        public String toString() {
            return "CarteBancaire{" +
                    "numeroCB='" + numeroCB + '\'' +
                    ", dateExpiration=" + dateExpiration +
                    ", titulaire='" + titulaire + '\'' +
                    '}';
        }

    }
