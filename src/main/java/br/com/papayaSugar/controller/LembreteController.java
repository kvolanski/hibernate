package br.com.papayaSugar.controller;

import br.com.papayaSugar.entity.Lembrete;

import javax.persistence.EntityManager;
import java.util.List;

public class LembreteController {


    public static void salvar(EntityManager entityManager, Lembrete lembrete) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(lembrete);
            entityManager.getTransaction().commit();
            System.out.println("INSERT " + lembrete.getDescricao().toString() + " " + lembrete.getTitulo().toString());

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            System.out.println("INSERT: " + e.getMessage());
        } finally {
            entityManager.close();
        }

    }


    public static void listar(EntityManager entityManager){

    List<Lembrete> lembretes = null;

    try{
        lembretes = entityManager.createQuery("from Lembrete ").getResultList();
    } catch (Exception e) {
        System.out.println("LIST ALL" + e.getMessage());

    }finally {
        entityManager.close();
    }

    if (lembretes != null){
        lembretes.forEach(System.out::println);
    }


    }


    public static void findById(EntityManager entityManager){

        try{
            Lembrete lembrete = null;
            lembrete = entityManager.find(Lembrete.class, 4L);

            if (lembrete == null){
                System.out.println("Não tem esse dado");
            }else{
                System.out.println(lembrete);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }

    }

    public static void findLike(EntityManager entityManager){

        List<Lembrete> lembretes = null;

        try{

            lembretes = entityManager.createQuery("from Lembrete l where l.titulo LIKE '%comprar%'").getResultList();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        };

        if(lembretes != null ){
            lembretes.forEach(System.out::println);
        }


    }


}


