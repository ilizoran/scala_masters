import scala.io.Source

/**
 * Developer object
 *
 * @param id       [String]
 * @param name     [String]
 * @param lastName [String]
 * @param country  [String]
 */
case class Developer(id:String, name: String, lastName: String, country: String)

/**
 * Used to display csv data to console
 */
object CsvReader {

  /**
   * Main
   * @param args
   */
  def main(args: Array[String]) {
    println("Welcome to csv reader app")
    val path: String = io.StdIn.readLine("Enter path to csv and press enter: ").toString
    val lines = mapProperly(Source.fromFile(path).getLines().drop(1).map(_.split(",").toList).toList)
    lines.foreach(developer => println("Name: " + developer.name + " Last Name: " + developer.lastName + " Country: " + developer.country))
  }

  /**
   * Transform List into developer class
   *
   * @param s List[String]
   *
   * @return [Developer]
   */
  def transformDeveloper(s: List[String]) = {
    Developer(s(0), s(1), s(2), s(3))
  }

  /**
   * Make list of developers
   *
   * @param developer
   * @return List[Developer]
   */
  def mapProperly(developer: List[List[String]]) = {
    developer.map(row => transformDeveloper(row))
  }
}
