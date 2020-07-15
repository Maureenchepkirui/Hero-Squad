import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        }else {
            port = 4567;
        }
        port(port);
        staticFileLocation("/public");
        Hero hero1 = new Hero("HenryDanger", 73, "Fire", "Water", 10, 50);
        Hero hero2 = new Hero("KidDanger", 7, "Indestructible ", " Girls", 10, 30);
        Hero hero3 = new Hero("Phoebe", 19, " Spit fire", "music", 20, 60);
        Hero hero4 = new Hero("Max", 19, "Freezing", "Girls", 10, 40);
        Hero hero5 = new Hero("Clowie", 2, "Vanishing", "Chocolates", 20, 40);
        Hero hero6 = new Hero("Billy", 9, "speed", "Food", 20, 60);
        Hero hero7 = new Hero("Norah", 7, "Electric-eyes", "Sleep", 10, 30);
        Hero hero8 = new Hero("Barb", 19, "Strong", "Cute men", 20, 30);


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("username", request.session().attribute("username"));

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
//Directing user to the welcome page after logging in
        post("/welcome", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String inputtedUsername = request.queryParams("username");
            request.session().attribute("username", inputtedUsername);
            model.put("username", inputtedUsername);

            return new ModelAndView(model, "index.hbs");//return index to display the page content
        }, new HandlebarsTemplateEngine());

        //request for deleting all heroes
        get("/heroes/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Hero.clearAll();
            model.put("heroes",Hero.getHeroes());
            return new ModelAndView(model,"hero-view.hbs");//view
//allowing user to create their heroes
        },new HandlebarsTemplateEngine());
        get("/create/hero",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hero-form.hbs");//the display the user is interacting with

        },new HandlebarsTemplateEngine());

//form action path.............
        post("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            int age=Integer.parseInt(request.queryParams("age"));
            String powers=request.queryParams("powers");
            String weakness=request.queryParams("weakness");
            int defence=Integer.parseInt(request.queryParams("defence"));
            int attack = Integer.parseInt(request.queryParams("attack"));
            Hero newHero = new Hero(name,age,powers,weakness,defence,attack);
            model.put("heroes", newHero);
            return new ModelAndView(model, "success.hbs");//..........view
        }, new HandlebarsTemplateEngine());
//<..............path for the see heroes button after user logging in....................
        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getHeroes();
            model.put("heroes", heroes);

            return new ModelAndView(model, "hero-view.hbs");//page the user interacts with..............
        }, new HandlebarsTemplateEngine());

//<...........getting details of a specific hero by matching id........................
        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            //id to match the route requested
            int idOfHeroToFind = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(idOfHeroToFind);
            model.put("hero", foundHero); //add it to model for template to display
            ArrayList<Hero> heroes = Hero.getHeroes();
            model.put("heroes", heroes);
            return new ModelAndView(model, "hero-view.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());

//        <...................clearing all squads....................
        get("/squads/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad.clearAll();
// <.........update heroes as not occupied since all squads have been cleared................................
            ArrayList<Hero> heroes=Hero.getHeroes();
            for (int i=0;i<heroes.size();i++){
                heroes.get(i).updateHero(false);
            }
            model.put("squads",Squad.getSquads());
            return new ModelAndView(model,"squad-view.hbs");

        },new HandlebarsTemplateEngine());
//<..............adding heroes to squad........heroes not occupied.................................
        get("/create/squad",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes=Hero.getHeroes();
            ArrayList<Hero> heroList=new ArrayList<>();
            for (int i=0;i<heroes.size();i++){
                if(heroes.get(i).isOccupied()==false){
                    heroList.add(heroes.get(i));
                }
            }

            model.put("heroes",Hero.getHeroes());
            return new ModelAndView(model,"squad-form.hbs");
        },new HandlebarsTemplateEngine());
        post("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            int maxSize=Integer.parseInt(request.queryParams("size"));
            String cause=request.queryParams("cause");
            ArrayList<Hero> heroes=new ArrayList<>();
            if(request.queryParamsValues("heroes")!=null){
                String[] heroesList=request.queryParamsValues("heroes");

                for(int i=0;i<heroesList.length;i++){
                    Hero addHero=Hero.findById(Integer.parseInt(heroesList[i]));
                    if(heroes.size()<maxSize){
                        addHero.updateHero(true);
                        heroes.add(addHero);
                    }

                }
            }
            Squad newSquad= new Squad(maxSize,name,cause,heroes);

            model.put("heroes",Hero.getHeroes());

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads",Squad.getSquads());
            return new ModelAndView(model,"squad-view.hbs");

        },new HandlebarsTemplateEngine());
        get("/index.hbs",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/hero-view",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-view.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squad-view",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind=Integer.parseInt(request.params(":id"));
            Squad foundSquad=Squad.findById(idOfSquadToFind);
            model.put("squad",foundSquad);
            ArrayList<Squad> squads=Squad.getSquads();
            model.put("squads",squads);
            return new ModelAndView(model,"squad-view.hbs");
        },new HandlebarsTemplateEngine());


        //delete hero

        get("/hero/:id/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete=Integer.parseInt(request.params(":id"));
            Hero foundHero=Hero.findById(idOfHeroToDelete);
            for (int i=idOfHeroToDelete;i<Hero.getHeroes().size();i++){
                Hero.getHeroes().get(i).setId(Hero.getHeroes().get(i).getId()-1);
            }
            foundHero.deleteHero();
            ArrayList<Hero> heroes = Hero.getHeroes();
            model.put("heroes", heroes);
            return new ModelAndView(model,"hero-view.hbs");

        },new HandlebarsTemplateEngine());
        get("/squad/:id/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToDelete=Integer.parseInt(request.params(":id"));
            Squad foundSquad=Squad.findById(idOfSquadToDelete);
            ArrayList<Hero> heroes=foundSquad.getHeroes();

            for(int i=0;i<heroes.size();i++){
                heroes.get(i).updateHero(false);
            }
            for (int i=idOfSquadToDelete;i<Squad.getSquads().size();i++){
                Squad.getSquads().get(i).setId(Squad.getSquads().get(i).getId()-1);
            }
            foundSquad.deleteSquad();

            ArrayList<Squad> squads = Squad.getSquads();
            model.put("squads", squads);
            return new ModelAndView(model,"squad-view.hbs");

        },new HandlebarsTemplateEngine());






    }
}