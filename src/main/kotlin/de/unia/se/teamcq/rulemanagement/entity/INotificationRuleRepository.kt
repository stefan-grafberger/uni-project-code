package de.unia.se.teamcq.rulemanagement.entity

import de.unia.se.teamcq.rulemanagement.model.NotificationRule
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
interface INotificationRuleRepository {

    fun getAllNotificationRulesForUser(username: String): List<NotificationRule>

    fun getNotificationRule(ruleId: Long): NotificationRule?

    fun createNotificationRule(notificationRule: NotificationRule): NotificationRule?

    fun updateNotificationRule(notificationRule: NotificationRule): NotificationRule?

    fun deleteNotificationRule(ruleId: Long)
}