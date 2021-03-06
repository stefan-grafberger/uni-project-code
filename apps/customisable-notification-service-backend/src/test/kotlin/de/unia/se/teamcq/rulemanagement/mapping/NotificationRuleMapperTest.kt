package de.unia.se.teamcq.rulemanagement.mapping

import de.unia.se.teamcq.TestUtils.getTestAggregatorDto
import de.unia.se.teamcq.TestUtils.getTestAggregatorEntity
import de.unia.se.teamcq.TestUtils.getTestAggregatorModel
import de.unia.se.teamcq.TestUtils.getTestFleetReferenceDto
import de.unia.se.teamcq.TestUtils.getTestFleetReferenceDtoTwo
import de.unia.se.teamcq.TestUtils.getTestFleetReferenceEntity
import de.unia.se.teamcq.TestUtils.getTestFleetReferenceEntityTwo
import de.unia.se.teamcq.TestUtils.getTestFleetReferenceModel
import de.unia.se.teamcq.TestUtils.getTestFleetReferenceModelTwo
import de.unia.se.teamcq.TestUtils.getTestNotificationRuleDto
import de.unia.se.teamcq.TestUtils.getTestNotificationRuleEntity
import de.unia.se.teamcq.TestUtils.getTestNotificationRuleModel
import de.unia.se.teamcq.TestUtils.getTestRecipientDtos
import de.unia.se.teamcq.TestUtils.getTestRecipientEntities
import de.unia.se.teamcq.TestUtils.getTestRecipientModels
import de.unia.se.teamcq.TestUtils.getTestRuleConditionDto
import de.unia.se.teamcq.TestUtils.getTestRuleConditionEntity
import de.unia.se.teamcq.TestUtils.getTestRuleConditionModel
import de.unia.se.teamcq.TestUtils.getTestUserDto
import de.unia.se.teamcq.TestUtils.getTestUserEntity
import de.unia.se.teamcq.TestUtils.getTestUserModel
import de.unia.se.teamcq.notificationmanagement.mapping.IAggregatorMapper
import de.unia.se.teamcq.ruleevaluation.mapping.IRuleConditionMapper
import de.unia.se.teamcq.user.mapping.AbstractUserMapper
import de.unia.se.teamcq.vehiclestate.mapping.AbstractFleetReferenceMapper
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [(TestConfiguration::class)])
class NotificationRuleMapperTest : StringSpec() {

    @MockK
    lateinit var mockIRuleConditionMapper: IRuleConditionMapper

    @MockK
    lateinit var mockAbstractFleetReferenceMapper: AbstractFleetReferenceMapper

    @MockK
    lateinit var mockIAggregatorMapper: IAggregatorMapper

    @MockK
    lateinit var mockAbstractUserMapper: AbstractUserMapper

    @MockK
    lateinit var mockRecipientMapperHelper: RecipientMapperHelper

    @InjectMockKs
    lateinit var notificationRuleMapper: AbstractNotificationRuleMapperImpl

    init {
        MockKAnnotations.init(this)

        "Convert model to entity" {

            every { mockIRuleConditionMapper.modelToEntity(any()) } returns getTestRuleConditionEntity()

            every { mockIAggregatorMapper.modelToEntity(any()) } returns getTestAggregatorEntity()

            every { mockAbstractUserMapper.modelToEntity(any()) } returns getTestUserEntity()

            every { mockRecipientMapperHelper.modelToEntity(any()) } returns getTestRecipientEntities()

            every { mockAbstractFleetReferenceMapper.modelToEntity(getTestFleetReferenceModel()) } returns
                    getTestFleetReferenceEntity()

            every { mockAbstractFleetReferenceMapper.modelToEntity(getTestFleetReferenceModelTwo()) } returns
                    getTestFleetReferenceEntityTwo()

            val notificationRule = getTestNotificationRuleModel()

            val notificationRuleEntity = notificationRuleMapper.modelToEntity(notificationRule)

            notificationRuleEntity shouldBe getTestNotificationRuleEntity()
        }

        "Convert entity to model" {

            every { mockIRuleConditionMapper.entityToModel(any()) } returns getTestRuleConditionModel()

            every { mockIAggregatorMapper.entityToModel(any()) } returns getTestAggregatorModel()

            every { mockIAggregatorMapper.entityToModel(any()) } returns getTestAggregatorModel()

            every { mockAbstractUserMapper.entityToModel(any()) } returns getTestUserModel()

            every { mockRecipientMapperHelper.entityToModel(any()) } returns getTestRecipientModels()

            every { mockAbstractFleetReferenceMapper.entityToModel(getTestFleetReferenceEntity()) } returns
                    getTestFleetReferenceModel()

            every { mockAbstractFleetReferenceMapper.entityToModel(getTestFleetReferenceEntityTwo()) } returns
                    getTestFleetReferenceModelTwo()

            val notificationRuleEntity = getTestNotificationRuleEntity()

            val notificationRule = notificationRuleMapper.entityToModel(notificationRuleEntity)

            notificationRule shouldBe getTestNotificationRuleModel()
        }

        "Convert model to dto" {

            every { mockIRuleConditionMapper.modelToDto(any()) } returns getTestRuleConditionDto()

            every { mockIAggregatorMapper.modelToDto(any()) } returns getTestAggregatorDto()

            every { mockIAggregatorMapper.modelToDto(any()) } returns getTestAggregatorDto()

            every { mockAbstractUserMapper.modelToDto(any()) } returns getTestUserDto()

            every { mockRecipientMapperHelper.modelToDto(any()) } returns getTestRecipientDtos()

            every { mockAbstractFleetReferenceMapper.modelToDto(getTestFleetReferenceModel()) } returns
                    getTestFleetReferenceDto()

            every { mockAbstractFleetReferenceMapper.modelToDto(getTestFleetReferenceModelTwo()) } returns
                    getTestFleetReferenceDtoTwo()

            val notificationRule = getTestNotificationRuleModel()

            val notificationRuleDto = notificationRuleMapper.modelToDto(notificationRule)

            notificationRuleDto shouldBe getTestNotificationRuleDto()
        }

        "Convert dto to model" should {

            "Work for legal arguments" {

                every { mockIRuleConditionMapper.dtoToModel(any()) } returns getTestRuleConditionModel()

                every { mockIAggregatorMapper.dtoToModel(any()) } returns getTestAggregatorModel()

                every { mockIAggregatorMapper.dtoToModel(any()) } returns getTestAggregatorModel()

                every { mockAbstractUserMapper.dtoToModel(any()) } returns getTestUserModel()

                every { mockRecipientMapperHelper.dtoToModel(any()) } returns getTestRecipientModels()

                every { mockAbstractFleetReferenceMapper.dtoToModel(getTestFleetReferenceDto()) } returns
                        getTestFleetReferenceModel()

                every { mockAbstractFleetReferenceMapper.dtoToModel(getTestFleetReferenceDtoTwo()) } returns
                        getTestFleetReferenceModelTwo()

                val notificationRuleDto = getTestNotificationRuleDto()

                val notificationRule = notificationRuleMapper.dtoToModel(notificationRuleDto)

                notificationRule shouldBe getTestNotificationRuleModel().apply {
                    lastUpdate = null
                }
            }

            "Throw an Exception if affectingAllApplicableFleets is null" {

                shouldThrow<IllegalArgumentException> {

                    val notificationRuleDto = getTestNotificationRuleDto().apply {
                        this.affectingAllApplicableFleets = null
                    }

                    notificationRuleMapper.dtoToModel(notificationRuleDto)
                }
            }

            "Throw an Exception if ownerAsAdditionalRecipient is null" {

                shouldThrow<IllegalArgumentException> {

                    val notificationRuleDto = getTestNotificationRuleDto().apply {
                        this.ownerAsAdditionalRecipient = null
                    }

                    notificationRuleMapper.dtoToModel(notificationRuleDto)
                }
            }

            "Throw an Exception if description is null" {

                shouldThrow<IllegalArgumentException> {

                    val notificationRuleDto = getTestNotificationRuleDto().apply {
                        this.description = null
                    }

                    notificationRuleMapper.dtoToModel(notificationRuleDto)
                }
            }

            "Throw an Exception if aggregator is null" {

                shouldThrow<IllegalArgumentException> {

                    val notificationRuleDto = getTestNotificationRuleDto().apply {
                        this.aggregator = null
                    }

                    notificationRuleMapper.dtoToModel(notificationRuleDto)
                }
            }

            "Throw an Exception if condition is null" {

                shouldThrow<IllegalArgumentException> {

                    val notificationRuleDto = getTestNotificationRuleDto().apply {
                        this.aggregator = null
                    }

                    notificationRuleMapper.dtoToModel(notificationRuleDto)
                }
            }

            "Throw an Exception if name is null" {

                shouldThrow<IllegalArgumentException> {

                    val notificationRuleDto = getTestNotificationRuleDto().apply {
                        this.name = null
                    }

                    notificationRuleMapper.dtoToModel(notificationRuleDto)
                }
            }

            "Throw an Exception if no potential recipient exists" {

                shouldThrow<IllegalArgumentException> {

                    val notificationRuleDto = getTestNotificationRuleDto().apply {
                        this.ownerAsAdditionalRecipient = false
                        this.recipients = listOf()
                    }

                    notificationRuleMapper.dtoToModel(notificationRuleDto)
                }
            }
        }
    }
}
