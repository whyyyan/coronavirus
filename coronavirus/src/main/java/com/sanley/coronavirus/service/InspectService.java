package com.sanley.coronavirus.service;

import com.sanley.coronavirus.entity.Inspect;

import java.util.List;

public interface InspectService {
    public List<Inspect> find(int baseId);
    public void add(Inspect inspect);
}
