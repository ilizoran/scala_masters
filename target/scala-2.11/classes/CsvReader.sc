import scala.io.Source

case class Developer(id: String, name: String, lastName: String, country: String)

def transformDeveloper(s: List[String]) = {
  Developer(s(0), s(1), s(2), s(3))
}

def mapProperly(developer: List[List[String]]) = {
  developer.map(row => transformDeveloper(row))
}

val csv = Source.fromFile("/Users/nenadpaic/Documents/development/test.csv").getLines()
val lines = mapProperly(csv.drop(1).map(_.split(",").toList).toList)
lines.foreach(developer => println(developer.name))