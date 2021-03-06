package de.unia.se.teamcq.ruleevaluation.controller

import de.unia.se.teamcq.ruleevaluation.dto.PredicateFieldProviderDto
import de.unia.se.teamcq.ruleevaluation.mapping.IPredicateFieldProviderMapper
import de.unia.se.teamcq.ruleevaluation.service.IPredicateFieldContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/predicate-fields")
class PredicateFieldController {

    @Autowired
    lateinit var predicateFieldContainer: IPredicateFieldContainer

    @Autowired
    lateinit var predicateFieldProviderMapper: IPredicateFieldProviderMapper

    @GetMapping
    fun getPredicateFieldProviders(): List<PredicateFieldProviderDto> {

        val predicateFieldProviders = predicateFieldContainer.getPredicateFieldProviders()

        return predicateFieldProviders
                .map { predicateFieldProvider -> predicateFieldProviderMapper.modelToDto(predicateFieldProvider) }
    }
}
