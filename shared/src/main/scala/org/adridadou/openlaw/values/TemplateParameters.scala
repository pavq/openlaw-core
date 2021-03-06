package org.adridadou.openlaw.values

import org.adridadou.openlaw.parser.template.VariableName

case class TemplateParameters(params:Map[VariableName, String] = Map()) {
  def strParams:Map[String, String] = params.map({case (key,value) => key.name -> value})
  def get(name: String):Option[String] = get(VariableName(name))
  def apply(name:String):String = apply(VariableName(name))

  def get(name: VariableName):Option[String] = params.get(name)
  def apply(name:VariableName):String = params(name)

  def +(param:(VariableName, String)):TemplateParameters = this.copy(params+param)
}

object TemplateParameters {
  def apply(params:(String, String)*):TemplateParameters = {
    val names = params.map({case (name, value) => VariableName(name) -> value})
    TemplateParameters(Map(names:_*))
  }
}