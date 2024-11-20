package com.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Entidad.Libro;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();


        // crearLibro("El Quijote", "Miguel de Cervantes", 1605);
        // crearLibro("El gato Negro", "Edgar Poe", 1750);

        Libro libro = leerLibro(5L);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro.getTitulo());
        }
        // actualizarLibro(1L, "Don Quijote de la Mancha", "Miguel de Cervantes Saavedra");
        // eliminarLibro(1L);
        em.close();
        emf.close();
    }

    // public static void crearLibro(String titulo, String autor, int anioPublicacion) {
    //     EntityManager em = emf.createEntityManager();
    //     em.getTransaction().begin();

    //     Libro libroUno = new Libro();
    //     libroUno.setTitulo(titulo);
    //     libroUno.setAutor(autor);
    //     libroUno.setAnioPublicacion(anioPublicacion);

    //     em.persist(libroUno);

    //     em.getTransaction().commit();
    //     em.close();
    // }

    public static Libro leerLibro(Long id) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, id);
        em.close();
        return libro;
    }
}

//     public static void actualizarLibro(Long id, String nuevoTitulo, String nuevoAutor) {
//         EntityManager em = emf.createEntityManager();
//         em.getTransaction().begin();
//         Libro libro = em.find(Libro.class, id);
//         if (libro != null) {
//             libro.setTitulo(nuevoTitulo);
//             libro.setAutor(nuevoAutor);
//             em.merge(libro);
//         }
//         em.getTransaction().commit();
//         em.close();
//     }

//     public static void eliminarLibro(Long id) {
//         EntityManager em = emf.createEntityManager();
//         em.getTransaction().begin();
//         Libro libro = em.find(Libro.class, id);
//         if (libro != null) {
//             em.remove(libro);
//         }
//         em.getTransaction().commit();
//         em.close();
//     }
// }

