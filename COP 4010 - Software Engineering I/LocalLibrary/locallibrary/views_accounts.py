from django.shortcuts import render
from catalog.models import BookInstance
from django.views import generic
from django.contrib.auth.mixins import LoginRequiredMixin
from django.urls import reverse


class UserHomeListView(LoginRequiredMixin, generic.ListView):
    model = BookInstance
    template_name = 'accounts/home.html'
    paginate_by = 10

    def get_queryset(self):
        return BookInstance.objects.filter(borrower=self.request.user).filter(status__exact='o').order_by('due_back')